package com.amadeus.amadeus.Services;

import com.amadeus.amadeus.Models.Airport;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.amadeus.Repository.AirportRepository;

@Service
public class AirportService {
    @Autowired

    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public Airport getAirport(String id) {
        return airportRepository.findById(id);
    }

    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void updateAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void deleteAirport(String id) {
        airportRepository.deleteById(id);
    }

    public List<Airport> getAllAirport() {
        return airportRepository.findAll();
    }
}