package com.amadeus.amadeus.Components;
import com.amadeus.amadeus.Repository.FlightRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amadeus.amadeus.Models.Flight;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

@Component
public class SyncFlights {


    private FlightRepository flightRepository;

        @Scheduled(cron = "0 0 0 * * *")
        public void syncFlights() {
            // Specify the path to the JSON file
            String filePath = "flights.json";
    
            // Create an instance of ObjectMapper and configure it
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
            // Read the JSON file and map it to an array of Flight objects
            try {
                Flight[] flights = objectMapper.readValue(new File(filePath), Flight[].class);
    
                // Iterate over the array of flights and save each one to the database
                for (Flight flight : flights) {
                    // Save the flight to the database
                    flightRepository.save(flight);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}