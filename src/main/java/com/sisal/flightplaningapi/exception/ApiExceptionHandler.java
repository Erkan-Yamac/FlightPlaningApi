package com.sisal.flightplaningapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({DailyLimitException.class})
    public ResponseEntity<?> entityNotFound(){
        return new ResponseEntity<>("There must be daily at most 3 flights for an airline between 2 destinations.",HttpStatus.CONFLICT);
        //return "There must be daily at most 3 flights for an airline between 2 destinations.";
    }
}