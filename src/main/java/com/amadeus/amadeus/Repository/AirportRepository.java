package com.amadeus.amadeus.Repository;

import com.amadeus.amadeus.Models.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.amadeus.amadeus.Models.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> searchAirportsByCity(String city);
    
    Airport findAirportById(Long id);
    List<Airport> findAirportsByCity(String city);

    void updateAirportById(Long id);
    

    void deleteAirportById(Long id);
    void deleteAirportByCity(String city);


}