package com.hotel.service.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(){
        super("Resource not found on server !!");
    }
    public RecordNotFoundException(String s) {
        super(s);
    }
}
