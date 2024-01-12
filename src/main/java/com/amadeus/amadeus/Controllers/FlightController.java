package com.amadeus.amadeus.Controllers;

import com.amadeus.amadeus.Models.Flight;
import com.amadeus.amadeus.Services.FlightService;
import com.amadeus.amadeus.Response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Read Specific Flight Details from DB
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightDetails(@PathVariable("id") Long id) {
        Flight flight = flightService.getFlight(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(flight);
    }

    // Read All Flight Details from DB
    @GetMapping
    public List<Flight> getAllFlightDetails() {
        return flightService.getAllFlight();
    }

    @PostMapping("/")
    public ResponseEntity<String> createFlightDetails(@RequestBody Flight flight) {
        flightService.createFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Flight created successfully.");
    }

    @PutMapping("/")
    public ResponseEntity<String> updateFlightDetails(@RequestBody Flight flight) {
        flightService.updateFlight(flight);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Flight updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlightDetails(@PathVariable("id") Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Flight deleted successfully.");
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam("departureCity") String departureCity,
            @RequestParam("arrivalCity") String arrivalCity,
            @RequestParam("departureDateTime") LocalDateTime departureDateTime,
            @RequestParam(value = "returnDateTime", required = false) LocalDateTime returnDateTime
    ) {
        return flightService.searchFlights(departureCity, arrivalCity, departureDateTime, returnDateTime);
    }

}
