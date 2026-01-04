package com.example.citybreakmanager.repository;

import com.example.citybreakmanager.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {}
