package com.rating.service.services.impl;

import com.rating.service.entitys.Rating;
import com.rating.service.repository.RatingRepository;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }
    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepository.findByHotelId(id);
    }
    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }
}
