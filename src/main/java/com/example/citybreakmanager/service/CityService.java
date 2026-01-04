package com.example.citybreakmanager.service;

import com.example.citybreakmanager.model.City;
import com.example.citybreakmanager.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
  private final CityRepository cityRepository;

  public List<City> getAllCities() {
    return cityRepository.findAll();
  }

  public City getCityById(Integer id) throws IllegalArgumentException {
    return cityRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException(id + "not found"));
  }

  public void insertCity(City city) {
    cityRepository.save(city);
  }

  public void updateCityById(Integer id, City city) {
    City selectedCity =
        cityRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

    selectedCity.setCountry(city.getCountry());
    selectedCity.setDetails(city.getDetails());
    selectedCity.setName(city.getName());

    cityRepository.save(selectedCity);
  }

  public void deleteCityById(Integer id) {
    City selectedCity =
        cityRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException(id + "not found"));
    cityRepository.delete(selectedCity);
  }
}
