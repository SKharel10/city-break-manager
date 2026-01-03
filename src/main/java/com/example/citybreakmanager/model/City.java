package com.example.citybreakmanager.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class City {
    @Id
    private int id;
    private String name;
    private String country;
    private String details;

    public City() {
    }

    public City(int id, String name, String country, String details) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(name, city.name) && Objects.equals(country, city.country) && Objects.equals(details, city.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, details);
    }
}

