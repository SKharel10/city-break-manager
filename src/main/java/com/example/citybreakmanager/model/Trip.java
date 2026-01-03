package com.example.citybreakmanager.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private City city;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer rating;
    private String personalNotes;

    public Trip() {
    }

    public Trip(Integer id, City city, LocalDate startDate, LocalDate endDate, Integer rating, String personalNotes) {
        this.id = id;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.personalNotes = personalNotes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPersonalNotes() {
        return personalNotes;
    }

    public void setPersonalNotes(String personalNotes) {
        this.personalNotes = personalNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) && Objects.equals(city, trip.city) && Objects.equals(startDate, trip.startDate) && Objects.equals(endDate, trip.endDate) && Objects.equals(rating, trip.rating) && Objects.equals(personalNotes, trip.personalNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, startDate, endDate, rating, personalNotes);
    }
}
