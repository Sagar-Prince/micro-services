package com.user.service.external.services;

import com.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/rating/saveRating")
    Rating createRating(@RequestBody Rating rating);
     
}
