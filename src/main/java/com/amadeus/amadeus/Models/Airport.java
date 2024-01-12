package com.amadeus.amadeus.Models;

import com.amadeus.amadeus.Repository.AirportRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;


    void Airport(String city) {
        this.city = city;
    }

    static void updateAirportById(Long id, String city) {
        Airport airport = AirportRepository.findAirportById(id).orElseThrow();
        airport.setCity(city);
        airport.save();
    }

    static void deleteAirportById(Long id) {
        Airport airport = Airport
        airport.delete();
    }

    static void createAirport(String city) {
        Airport airport = new Airport();
        airport.setCity(city);
        airport.save();
    }


    static Airport findByCity(String city) {
        return Airport.findByCity(city);
    }


}
