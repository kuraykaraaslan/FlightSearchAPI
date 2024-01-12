package com.amadeus.Repository;

import com.amadeus.Models.Flight;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findById(String id);

    void deleteById(String id);

    List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime departureDateTime,
            LocalDateTime returnDateTime);
    
}
