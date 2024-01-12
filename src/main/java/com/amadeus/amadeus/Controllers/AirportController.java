package com.amadeus.amadeus.Controllers;

import com.amadeus.amadeus.Models.Airport;
import com.amadeus.amadeus.Services.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    // Read Specific Airport Details from DB
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportDetails(@PathVariable("id") Long id) {
        Airport airport = airportService.getAirport(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(airport);
    }

    // Read All Airport Details from DB
    @GetMapping
    public List<Airport> getAllAirportDetails() {
        return airportService.getAllAirport();
    }

    @PostMapping("/")
    public ResponseEntity<String> createAirportDetails(@RequestBody Airport airport) {
        airportService.createAirport(airport);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Airport created successfully.");
    }

    @PutMapping("/")
    public ResponseEntity<String> updateAirportDetails(@RequestBody Airport airport) {
        airportService.updateAirport(airport);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Airport updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirportDetails(@PathVariable("id") Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Airport deleted successfully.");
    }
}
