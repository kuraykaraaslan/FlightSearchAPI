package com.amadeus.amadeus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.amadeus.amadeus.Models.Flight;
import com.amadeus.amadeus.Repository.FlightRepository;
import com.amadeus.amadeus.Repository.AirportRepository;
import com.amadeus.amadeus.Requests.FlightRequest;

/**
 * This class represents the Flight Controller, which handles HTTP requests related to flights.
 */
@RestController
@RequestMapping("api/flights")
public class FlightController {
    
    // Autowiring the FlightRepository and AirportRepository dependencies
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Retrieves a list of all flights.
     * Endpoint: GET /flights
     * @return List of Flight objects
     */
    @GetMapping
    @Secured("ROLE_USER")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    /**
     * Creates a new flight based on the provided FlightRequest.
     * Endpoint: POST /flights
     * @param flightRequest The request object containing flight details
     * @return The newly created Flight object
     */
    @PostMapping
    @Secured("ROLE_ADMIN")
    public Flight createFlight(@RequestBody FlightRequest flightRequest) {
        Flight newFlight = new Flight();
        newFlight.setDepartureAirport(airportRepository.findById(flightRequest.getDepartureAirportId()).orElse(null));
        newFlight.setArrivalAirport(airportRepository.findById(flightRequest.getArrivalAirportId()).orElse(null));
        newFlight.setDepartureDateTime(flightRequest.getDepartureDateTime());
        newFlight.setReturnDateTime(flightRequest.getReturnDateTime());
        newFlight.setPrice(flightRequest.getPrice());
        return flightRepository.save(newFlight);
    }

    /**
     * Retrieves a flight with the specified ID.
     * Endpoint: GET /flights/{id}
     * @param id The ID of the flight to retrieve
     * @return The Flight object with the specified ID or null if not found
     */
    @GetMapping("/{id}")
    @Secured("ROLE_USER")
    public Flight getFlightById(@PathVariable Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing flight with the specified ID based on the provided FlightRequest.
     * Endpoint: PUT /flights/{id}
     * @param id The ID of the flight to update
     * @param flightRequest The request object containing updated flight details
     * @return The updated Flight object or null if the flight with the specified ID is not found
     */
    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Flight updateFlight(@PathVariable Long id, @RequestBody FlightRequest flightRequest) {
        Flight flight = flightRepository.findById(id).orElse(null);
        flight.setDepartureAirport(airportRepository.findById(flightRequest.getDepartureAirportId()).orElse(null));
        flight.setArrivalAirport(airportRepository.findById(flightRequest.getArrivalAirportId()).orElse(null));
        flight.setDepartureDateTime(flightRequest.getDepartureDateTime());
        flight.setReturnDateTime(flightRequest.getReturnDateTime());
        flight.setPrice(flightRequest.getPrice());
        return flightRepository.save(flight);
    }

    /**
     * Deletes a flight with the specified ID.
     * Endpoint: DELETE /flights/{id}
     * @param id The ID of the flight to delete
     */
    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public void deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
    }

    /**
     * Authenticates a user.
     * Endpoint: POST /flights/authenticate
     * @param authentication The authentication object
     * @return The authentication object
     */
    @PostMapping("/authenticate")
    public Authentication authenticate(@RequestBody Authentication authentication) {
        Authentication authenticated = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticated);
        return authenticated;
    }
}
