package com.rating.service.services;

import com.rating.service.entitys.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);
    List<Rating> getAllRating();
    List<Rating> getRatingByHotelId(String id);
    List<Rating> getRatingByUserId(String userId);



}
