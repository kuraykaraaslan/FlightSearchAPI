package com.amadeus.amadeus.Requests; // Declares the package name

import java.util.Date; // Importing the Date class from the java.util package

/**
 * Represents a flight request with departure and arrival airport IDs, departure and return date times, and price.
 */
public class FlightRequest {

    private Long departureAirportId; // Private instance variable to store the departure airport ID
    private Long arrivalAirportId; // Private instance variable to store the arrival airport ID
    private Date departureDateTime; // Private instance variable to store the departure date and time
    private Date returnDateTime; // Private instance variable to store the return date and time
    private double price; // Private instance variable to store the price

    // Getter and Setter methods

    /**
     * Getter for departureAirportId
     * @return the current departureAirportId
     */
    public Long getDepartureAirportId() {
        return departureAirportId;
    }

    /**
     * Setter for departureAirportId
     * @param departureAirportId the new departureAirportId to set
     */
    public void setDepartureAirportId(Long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    /**
     * Getter for arrivalAirportId
     * @return the current arrivalAirportId
     */
    public Long getArrivalAirportId() {
        return arrivalAirportId;
    }
    
    /**
     * Setter for arrivalAirportId
     * @param arrivalAirportId the new arrivalAirportId to set
     */
    public void setArrivalAirportId(Long arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    /**
     * Getter for departureDateTime
     * @return the current departureDateTime
     */
    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * Setter for departureDateTime
     * @param departureDateTime the new departureDateTime to set
     */
    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * Getter for returnDateTime
     * @return the current returnDateTime
     */
    public Date getReturnDateTime() {
        return returnDateTime;
    }

    /**
     * Setter for returnDateTime
     * @param returnDateTime the new returnDateTime to set
     */
    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    /**
     * Getter for price
     * @return the current price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price the new price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
