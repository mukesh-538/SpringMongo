package com.spring.mongo.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String msg){
        super(msg);
    }
}
