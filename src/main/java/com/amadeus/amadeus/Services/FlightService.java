// Filename: FlightService.java
package com.amadeus.amadeus.Services;
import com.amadeus.amadeus.Models.Flight;
import com.amadeus.amadeus.Repository.FlightRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightById(Long id) {
        List<Flight> flights = new ArrayList<>();
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        optionalFlight.ifPresent(flights::add);
        return flights;
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            Flight flightToUpdate = optionalFlight.get();
            flightToUpdate.setDepartureAirport(flight.getDepartureAirport());
            flightToUpdate.setArrivalAirport(flight.getArrivalAirport());
            flightToUpdate.setDepartureDateTime(flight.getDepartureDateTime());
            flightToUpdate.setReturnDateTime(flight.getReturnDateTime());
            flightToUpdate.setPrice(flight.getPrice());
            return flightRepository.save(flightToUpdate);
        } else {
            return null;
        }
    }
}
