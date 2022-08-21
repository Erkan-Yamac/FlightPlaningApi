package com.sisal.flightplaningapi.repository;

import com.sisal.flightplaningapi.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight,Long> {

    @Query(value = "SELECT COUNT(t.id ) FROM Flight t WHERE CAST(t.flight_date AS date)=CAST(:FLIGHT_DATE AS date) and t.airline_code = :AIRLINE_CODE and ((t.source_airport_code = :SOURCE_AIRPORT_CODE and t.destination_airport_code= :DESTINATION_AIRPORT_CODE) or (t.source_airport_code=:DESTINATION_AIRPORT_CODE and t.destination_airport_code=:SOURCE_AIRPORT_CODE))")
    public int sameDayFlightCount(@Param("AIRLINE_CODE") String AIRLINE_CODE ,
                                  @Param("SOURCE_AIRPORT_CODE") String SOURCE_AIRPORT_CODE,
                                  @Param("DESTINATION_AIRPORT_CODE") String DESTINATION_AIRPORT_CODE,
                                  @Param("FLIGHT_DATE") Date FLIGHT_DATE);

}
