package com.example.citybreakmanager.service;

import com.example.citybreakmanager.model.City;
import com.example.citybreakmanager.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Integer id) throws IllegalArgumentException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));
    }

    public void insertCity(City city){
        cityRepository.save(city);
    }

    public void updateCityById(Integer id, City city){
        City selectedCity = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

        selectedCity.setId(city.getId());
        selectedCity.setCountry(city.getCountry());
        selectedCity.setDetails(city.getDetails());
        selectedCity.setName(city.getName());

        cityRepository.save(selectedCity);

    }

    public void deleteCityById(Integer id){
        City selectedCity = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));
        cityRepository.deleteById(id);
    }

}
