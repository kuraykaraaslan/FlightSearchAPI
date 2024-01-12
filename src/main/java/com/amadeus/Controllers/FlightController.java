package com.amadeus.Controllers;

import com.amadeus.Models.Flight;
import com.amadeus.Services.FlightService;
import com.amadeus.Views.Auth.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }
        
    // Read Specific Flight Details from DB
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFlightDetails(@PathVariable("id") String id){
        // Return response using Login class's responseBuilder method
        return Login.responseBuilder("Requested Flight details are given here.", HttpStatus.OK, flightService.getFlight(id));
    }

    // Read All Flight Details from DB
    @GetMapping()
    public List<Flight> getAllFlightDetails(){
        return flightService.getAllFlight();
    }

    @PostMapping
    public String createFlightDetails(@RequestBody Flight flight){
        flightService.createFlight(flight);
        return "Flight created successfully.";
    }
    
    @PutMapping
    public String updateFlightDetails(@RequestBody Flight flight){
        flightService.updateFlight(flight);
        return "Flight updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteFlightDetails(@PathVariable("id") String id){
        flightService.deleteFlight(id);
        return "Flight deleted successfully.";
    }

        @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam("departureCity") String departureCity,
            @RequestParam("arrivalCity") String arrivalCity,
            @RequestParam("departureDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(value = "returnDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime
    ) {
        return flightService.searchFlights(departureCity, arrivalCity, departureDateTime, returnDateTime);
    }
    
}
