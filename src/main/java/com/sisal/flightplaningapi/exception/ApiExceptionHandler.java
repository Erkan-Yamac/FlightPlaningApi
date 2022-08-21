package com.sisal.flightplaningapi.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({DailyLimitException.class})
    public String entityNotFound(){
        return "There must be daily at most 3 flights for an airline between 2 destinations.";
    }
}