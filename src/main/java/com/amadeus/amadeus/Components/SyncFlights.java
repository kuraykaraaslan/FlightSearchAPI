package com.amadeus.amadeus.Components;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.amadeus.amadeus.Models.Flight;


public class SyncFlights {

    public Flight[] syncFlights() throws IOException {
        // Specify the path to the JSON file
        String filePath = "flights.json";

        // Create an instance of ObjectMapper and configure it
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Read the JSON file and map it to an array of Flight objects
        return objectMapper.readValue(new File(filePath), Flight[].class);
    }
}
