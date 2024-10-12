package com.hotel.service.paylod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse {

    private String message;
    private HttpStatus httpStatus;
    private boolean success;

}
