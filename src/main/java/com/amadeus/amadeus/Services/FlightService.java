package com.amadeus.amadeus.Services;

import com.amadeus.amadeus.Models.Flight;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Repository.FlightRepository;

@Service
public class FlightService {
    @Autowired

    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight saveFlight(Flight Flight) {
        return flightRepository.save(Flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight getFlight(String id) {
        return flightRepository.findById(id);
    }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime departureDateTime,
            LocalDateTime returnDateTime) {
        return flightRepository.searchFlights(departureCity, arrivalCity, departureDateTime, returnDateTime);
    }

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

}