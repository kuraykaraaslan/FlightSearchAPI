package com.amadeus.amadeus.Components;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.amadeus.amadeus.Models.Flight;

public class SyncFlights {

    public Flight[] syncFlights() {
        try {
            // Specify the path to the JSON file
            String filePath = "flights.json";

            // Create an instance of ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file and map it to a Java objects
            Flight[] flights = objectMapper.readValue(new File(filePath), Flight[].class);

            // Print the objects
            return flights;

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }

}
