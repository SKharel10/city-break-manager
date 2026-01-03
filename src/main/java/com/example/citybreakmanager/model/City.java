package com.example.citybreakmanager.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @Column(name="city_id")
    private int id;
    private String name;
    private String country;
    private String details;

    @OneToMany(mappedBy = "city")
    private List<Trip> listOfTrips;

}

