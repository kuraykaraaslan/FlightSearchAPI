package com.amadeus.amadeus.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents an airport entity.
 */
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    /**
     * Empty constructor for Airport class.
     */
    public Airport() {
    }

    /**
     * Static method to create an Airport object.
     * @param city The city of the airport
     * @return The created Airport object
     */
    public static Airport createAirport(String city) {
        Airport airport = new Airport();
        airport.setCity(city);
        return airport;
    }

    /**
     * Getter method for the ID of the airport.
     * @return The ID of the airport
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for the ID of the airport.
     * @param id The ID of the airport
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for the city of the airport.
     * @return The city of the airport
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter method for the city of the airport.
     * @param city The city of the airport
     */
    public void setCity(String city) {
        this.city = city;
    }
}
