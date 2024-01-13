package com.amadeus.amadeus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amadeus.amadeus.Models.Flight;
import java.util.List;

/**
 * This interface represents a repository for managing Flight entities.
 * It extends the JpaRepository interface, providing basic CRUD operations for Flight entities.
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Additional query methods can be added here if needed
    
    /**
     * Retrieves a Flight entity by its ID.
     *
     * @return The Flight entity with the specified ID, or null if not found.
     */
    public Flight findById();

    /**
     * Retrieves all Flight entities.
     *
     * @return A list of all Flight entities.
     */
    public List<Flight> findAll();

    /**
     * Retrieves a default Flight entity if no entity is found.
     *
     * @return The default Flight entity.
     */
    public Flight orElse();
}
