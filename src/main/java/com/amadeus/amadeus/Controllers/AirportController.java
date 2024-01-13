package com.amadeus.amadeus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.amadeus.amadeus.Models.Airport;
import com.amadeus.amadeus.Requests.AirportRequest;
import com.amadeus.amadeus.Repository.AirportRepository;

/**
 * This class is a controller for handling airport-related operations.
 */
@RestController
@RequestMapping("api/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    /**
     * Get all airports.
     *
     * @return List of all airports.
     */
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    /**
     * Create a new airport.
     *
     * @param airportRequest The request body containing the airport details.
     * @return The created airport.
     */
    @PostMapping
    public Airport createAirport(@RequestBody AirportRequest airportRequest) {
        Airport newAirport = new Airport();
        newAirport.setCity(airportRequest.getCity());

        return airportRepository.save(newAirport);
    }

    /**
     * Get an airport by its ID.
     *
     * @param id The ID of the airport to retrieve.
     * @return The airport with the given ID if found, or null if not found.
     */
    @GetMapping("/{id}")
    @Secured("ROLE_USER")
    public Airport getAirportById(@PathVariable Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    /**
     * Update an existing airport.
     *
     * @param id             The ID of the airport to update.
     * @param airportRequest The request body containing the updated airport details.
     * @return The updated airport.
     */
    @PutMapping("/{id}")
    @Secured("ROLE_USER")
    public Airport updateAirport(@PathVariable Long id, @RequestBody AirportRequest airportRequest) {
        Airport airport = airportRepository.findById(id).orElse(null);
        airport.setCity(airportRequest.getCity());
        return airportRepository.save(airport);
    }

    /**
     * Delete an airport by its ID.
     *
     * @param id The ID of the airport to delete.
     */
    @DeleteMapping("/{id}")
    @Secured("ROLE_USER")
    public void deleteAirport(@PathVariable Long id) {
        airportRepository.deleteById(id);
    }

}
