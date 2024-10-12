package com.user.service.service.impl;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String string = UUID.randomUUID().toString();
        user.setUserId(string);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> all = userRepository.findAll();
        for (User user : all) {
            Rating[] ratingByUserId = restTemplate.getForObject("http://RATING-SERVICE/rating/allUserRating/" + user.getUserId(), Rating[].class);
            assert ratingByUserId != null;
            List<Rating> rating = Arrays.stream(ratingByUserId).collect(Collectors.toList());
            rating.stream().peek(ratings ->{
                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/hotel/" + ratings.getHotelId(), Hotel.class);
                log.info("hotelResponse : "+forEntity.getStatusCode());
                ratings.setHotel(forEntity.getBody());
            }).collect(Collectors.toList());
            user.setRating(rating);
        }
        return all;

    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id not found on server !!" + userId));
        Rating[] ratingByUserId = restTemplate.getForObject("http://RATING-SERVICE/rating/allUserRating/" + user.getUserId(), Rating[].class);
        assert ratingByUserId != null;
        List<Rating> rating = Arrays.stream(ratingByUserId).collect(Collectors.toList());
        rating.stream().peek(ratings ->{
           ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/hotel/" + ratings.getHotelId(), Hotel.class);
            log.info("hotelResponse : "+forEntity.getStatusCode());
            //ResponseEntity<Hotel> hotel = hotelService.getHotel(ratings.getHotelId());
            Hotel hotel = forEntity.getBody();
            log.info(" hotel - service : "+hotel.toString());
           // Hotel body = hotel.getBody();
            ratings.setHotel(hotel);
        }).collect(Collectors.toList());
        user.setRating(rating);
        return user;

    }
}
