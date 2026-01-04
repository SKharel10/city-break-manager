package com.example.citybreakmanager.service;

import com.example.citybreakmanager.model.City;
import com.example.citybreakmanager.model.Trip;
import com.example.citybreakmanager.repository.CityRepository;
import com.example.citybreakmanager.repository.TripRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TripService {
  private final TripRepository tripRepository;
  private final CityRepository cityRepository;

  public TripService(TripRepository tripRepository, CityRepository cityRepository) {
    this.tripRepository = tripRepository;
    this.cityRepository = cityRepository;
  }

  public List<Trip> getAllTrips() {
    return tripRepository.findAll();
  }

  public Trip getTripById(Integer id) {
    return tripRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException(id + "not found"));
  }

  public void insertTrip(Trip trip) {
    Integer searchedCityId = trip.getCity().getId();
    City searchedCity =
        cityRepository
            .findById(searchedCityId)
            .orElseThrow(() -> new IllegalArgumentException(trip.getCity().getId() + "not found"));
    trip.setCity(searchedCity);

    tripRepository.save(trip);
  }

  public void updateTripById(Integer id, Trip trip) {
    Trip selectedTrip =
        tripRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

    Integer searchedCityId = trip.getCity().getId();

    City searchedCity =
        cityRepository
            .findById(searchedCityId)
            .orElseThrow(() -> new IllegalArgumentException(trip.getCity().getId() + "not found"));

    selectedTrip.setCity(searchedCity);
    selectedTrip.setStartDate(trip.getStartDate());
    selectedTrip.setEndDate(trip.getEndDate());
    selectedTrip.setRating(trip.getRating());
    selectedTrip.setPersonalNotes(trip.getPersonalNotes());

    tripRepository.save(selectedTrip);
  }

  public void deleteTripById(Integer id) {
    Trip selectedTrip =
        tripRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

    tripRepository.delete(selectedTrip);
  }
}
