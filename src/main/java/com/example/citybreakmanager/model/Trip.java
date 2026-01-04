package com.example.citybreakmanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Trip {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne private City city;
  private LocalDate startDate;
  private LocalDate endDate;
  private Integer rating;
  private String personalNotes;

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

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getPersonalNotes() {
    return personalNotes;
  }

  public void setPersonalNotes(String personalNotes) {
    this.personalNotes = personalNotes;
  }
}
