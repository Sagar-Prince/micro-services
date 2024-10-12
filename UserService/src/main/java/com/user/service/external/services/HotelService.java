package com.user.service.external.services;

import com.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/hotel/{id}")
    ResponseEntity<Hotel> getHotel(@PathVariable("id") String id);

}
