package com.amadeus.amadeus.Controllers;

import com.amadeus.amadeus.Models.Airport;
import com.amadeus.amadeus.Services.AirportService;
import com.amadeus.amadeus.Response.Response;

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
    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }
        
    // Read Specific Airport Details from DB
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAirportDetails(@PathVariable("id") String id){
        // Return response using Login class's responseBuilder method
        return Response.responseBuilder("Requested Airport details are given here.", HttpStatus.OK, airportService.getAirport(id));
    }

    // Read All Airport Details from DB
    @GetMapping()
    public List<Airport> getAllAirportDetails(){
        return airportService.getAllAirport();
    }

    @PostMapping
    public String createAirportDetails(@RequestBody Airport airport){
        airportService.createAirport(airport);
        return "Airport created successfully.";
    }
    
    @PutMapping
    public String updateAirportDetails(@RequestBody Airport airport){
        airportService.updateAirport(airport);
        return "Airport updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteAirportDetails(@PathVariable("id") String id){
        airportService.deleteAirport(id);
        return "Airport deleted successfully.";
    }
}
