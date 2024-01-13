package com.amadeus.amadeus.Models;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Represents a flight.
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    private Date departureDateTime;
    private Date returnDateTime;
    private double price;

    /**
     * Empty constructor for Flight class.
     */
    public Flight() {
    }

    /**
     * Getter method for the ID of the flight.
     * @return The ID of the flight
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for the ID of the flight.
     * @param id The ID of the flight
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for the departure airport of the flight.
     * @return The departure airport of the flight
     */
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Setter method for the departure airport of the flight.
     * @param departureAirport The departure airport of the flight
     */
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * Getter method for the arrival airport of the flight.
     * @return The arrival airport of the flight
     */
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * Setter method for the arrival airport of the flight.
     * @param arrivalAirport The arrival airport of the flight
     */
    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /**
     * Getter method for the departure date and time of the flight.
     * @return The departure date and time of the flight
     */
    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * Setter method for the departure date and time of the flight.
     * @param departureDateTime The departure date and time of the flight
     */
    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * Getter method for the return date and time of the flight.
     * @return The return date and time of the flight
     */
    public Date getReturnDateTime() {
        return returnDateTime;
    }

    /**
     * Setter method for the return date and time of the flight.
     * @param returnDateTime The return date and time of the flight
     */
    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    /**
     * Getter method for the price of the flight.
     * @return The price of the flight
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for the price of the flight.
     * @param price The price of the flight
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Placeholder method for mapping an object.
     * @param object The object to be mapped
     * @return The mapped object
     * @throws UnsupportedOperationException If the method is not implemented
     */
    public Object map(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
}
