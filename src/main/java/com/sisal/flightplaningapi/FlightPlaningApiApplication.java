package com.sisal.flightplaningapi;

import com.sisal.flightplaningapi.model.Flight;
import com.sisal.flightplaningapi.repository.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlightPlaningApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(FlightPlaningApiApplication.class, args);


    }

}
