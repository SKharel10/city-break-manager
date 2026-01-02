package com.example.citybreakmanager.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
public class City {
    @Id
    @Column(name="city_id")
    private int id;
    private String name;
    private String country;
    private String details;

    @OneToMany(mappedBy = "trip_id")
    private List<Trip> listOfTrips;

}

