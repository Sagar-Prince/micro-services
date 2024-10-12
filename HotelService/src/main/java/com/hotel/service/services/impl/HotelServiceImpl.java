package com.hotel.service.services.impl;

import com.hotel.service.entity.Hotel;
import com.hotel.service.exception.RecordNotFoundException;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() ->new RecordNotFoundException("Hotel with given id not found on server "+id));
    }
    @Override
    public Hotel createHotel(Hotel hotel) {
        String string = UUID.randomUUID().toString();
        hotel.setId(string);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        List<Hotel> all = hotelRepository.findAll();
        return all;
    }
}
