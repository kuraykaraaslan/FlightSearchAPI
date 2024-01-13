package com.amadeus.amadeus.Repository; 
import com.amadeus.amadeus.Models.Airport; 
import org.springframework.data.jpa.repository.JpaRepository; 
import java.util.List;

/**
 * This interface represents a repository for managing airports.
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    // Additional query methods can be added here if needed
    
    /**
     * Retrieves an airport by its ID
     * 
     * @return the airport found with the given ID
     */
    public Airport findById();
    
    /**
     * Retrieves all airports
     * 
     * @return a list of all airports
     */
    public List<Airport> findAll();
    
    /**
     * Retrieves an alternative airport if the requested one is not found
     * 
     * @return an alternative airport
     */
    public Airport orElse();
}
