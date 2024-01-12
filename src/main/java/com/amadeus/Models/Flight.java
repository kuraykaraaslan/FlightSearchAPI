package com.amadeus.Models;

import java.math.BigDecimal;
import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_date_time")
    @Setter
    @Getter
    private Timestamp departureDateTime;

    @Column(name = "return_date_time")
    @Setter
    @Getter
    private Timestamp returnDateTime;


    @Column(name = "price")
    @Setter
    @Getter
    private BigDecimal price;


}
