package com.rating.service.controller;

import com.rating.service.entitys.Rating;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService service;
    @PostMapping("/saveRating")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        Rating rating1 = service.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }
    @GetMapping("/allRating")
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllRating());
    }
    @GetMapping("/allUserRating/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getRatingByUserId(userId));
    }
    @GetMapping("/allHotelRating/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getRatingByHotelId(hotelId));
    }

}
