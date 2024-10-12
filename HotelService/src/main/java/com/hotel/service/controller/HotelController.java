package com.hotel.service.controller;

import com.hotel.service.entity.Hotel;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
        Hotel hotel = hotelService.getHotel(id);
        return new ResponseEntity<>(hotel, HttpStatus.FOUND);
    }

    @PostMapping("/saveHotel")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        Hotel saveHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(saveHotel, HttpStatus.CREATED);
    }
    @GetMapping("/allHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotel = hotelService.getAllHotel();
        return new ResponseEntity<>(allHotel, HttpStatus.OK);

    }


}
