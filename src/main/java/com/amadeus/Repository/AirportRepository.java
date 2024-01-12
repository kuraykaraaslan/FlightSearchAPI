package com.amadeus.Repository;

import com.amadeus.Models.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findById(String id);
    Airport findByCity(String city);
    Airport findByCountry(String country);
    

    void deleteById(String id);

    List<Airport> searchAirports(String city, String country);
    
}
