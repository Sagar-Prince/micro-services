package com.hotel.service.services;

import com.hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel getHotel(String id);
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotel();


}
