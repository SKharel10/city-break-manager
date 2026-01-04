package com.example.citybreakmanager.controller;

import com.example.citybreakmanager.model.Trip;
import com.example.citybreakmanager.service.TripService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class TripController {

  private final TripService tripService;

  public TripController(TripService tripService) {
    this.tripService = tripService;
  }

  @GetMapping
  public List<Trip> getAllTrips() {
    return tripService.getAllTrips();
  }

  @GetMapping("{id}")
  public Trip getTripById(@PathVariable Integer id) {
    return tripService.getTripById(id);
  }

  @PostMapping()
  public void insertTrip(@RequestBody Trip trip) {
    tripService.insertTrip(trip);
  }

  @PutMapping("{id}")
  public void updateTripById(@PathVariable Integer id, @RequestBody Trip trip) {
    tripService.updateTripById(id, trip);
  }

  @DeleteMapping("{id}")
  public void deleteTripById(@PathVariable Integer id) {
    tripService.deleteTripById(id);
  }
}
