package com.rating.service.repository;

import com.rating.service.entitys.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    //custom method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
