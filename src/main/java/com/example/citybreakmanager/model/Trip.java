package com.example.citybreakmanager.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trip_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer rating;
    private String personalNotes;
}
