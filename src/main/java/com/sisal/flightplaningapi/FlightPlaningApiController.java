package com.sisal.flightplaningapi;

import com.sisal.flightplaningapi.exception.DailyLimitException;
import com.sisal.flightplaningapi.model.Flight;
import com.sisal.flightplaningapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightPlaningApiController {

    @RequestMapping
    public String flightPlaningApi(){
        return "Hello World from Spring Boot";
    }
    @RequestMapping("/goodbye")
    public String goodbye(){

        return "bye";
    }

    @Autowired
    FlightRepository flightRepo;

    @PostMapping("/Flights")
    public ResponseEntity<Flight> save(@RequestBody Flight flight){
       try {

           if(flightRepo.sameDayFlightCount(flight.getAirline_code(),flight.getSource_airport_code(),flight.getDestination_airport_code(), flight.getFlight_date())==3)
           {
               throw new DailyLimitException();
           }
           else{
               return new ResponseEntity<>(flightRepo.save(flight), HttpStatus.CREATED);
           }
       }
       catch(DailyLimitException e){
           throw new DailyLimitException();
           //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
       catch(Exception e){
           //throw new DailyLimitException();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping("/Flights")
    public ResponseEntity<List<Flight>>  getAllFlights(){


        try {
           List<Flight> list= (List<Flight>) flightRepo.findAll();
           if(list.isEmpty()||list.size()==0){
               return new ResponseEntity<List<Flight>>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<List<Flight>>(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

}

