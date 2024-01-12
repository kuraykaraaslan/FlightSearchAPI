package com.amadeus.amadeus.Repository;

import com.amadeus.amadeus.Models.Flight;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findFlightById(Long id);
    List<Flight> findFlightsByDepartureAirport(String departureAirport);
    List<Flight> findFlightsByArrivalAirport(String arrivalAirport);
    List<Flight> findFlightsByDepartureDateTime(LocalDateTime departureDateTime);
    List<Flight> findFlightsByReturnDateTime(LocalDateTime returnDateTime);
    List<Flight> findFlightsByPrice(Double price);

    void updateFlightById(Long id);

    void deleteFlightById(Long id);

    List<Flight> searchFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime,
            LocalDateTime returnDateTime);

}
