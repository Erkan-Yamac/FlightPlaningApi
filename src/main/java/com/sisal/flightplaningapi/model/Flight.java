package com.sisal.flightplaningapi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Entity
@Table(name="TBL_FLIGHTPLAN")
@Setter
@Getter
@ToString
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  airline_code;
    private String  source_airport_code;
    private String  destination_airport_code;
    private Date flight_date;




}
