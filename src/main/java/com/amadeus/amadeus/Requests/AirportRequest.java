package com.amadeus.amadeus.Requests; // Declares the package name

/**
 * Represents an airport request with the city name.
 */
public class AirportRequest {

    private String city; // Private instance variable to store the city name

    // Getter and Setter methods

    /**
     * Getter for city
     * @return the current city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city
     * @param city the new city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}
