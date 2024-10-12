package com.hotel.service.exception;

import com.hotel.service.paylod.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {


  /*  @ExceptionHandler(RecordNotFoundException.class)
    ResponseEntity<ApiResponse> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException){
        String message = recordNotFoundException.getMessage();
        ApiResponse build = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);

    }*/
  @ExceptionHandler(RecordNotFoundException.class)
    ResponseEntity<Map<String, String>> noFoundHandler(RecordNotFoundException recordNotFoundException){
      Map<String, String> map = new HashMap<String, String>();
      map.put("message",recordNotFoundException.getMessage());
      map.put("success","false");
      map.put("status",HttpStatus.NOT_FOUND.toString());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

}
