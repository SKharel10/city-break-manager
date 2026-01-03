package com.example.citybreakmanager.controller;

import com.example.citybreakmanager.model.City;
import com.example.citybreakmanager.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService){
        this.cityService = cityService;
    }


    @GetMapping
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("{id}")
    public City getCityById(@PathVariable Integer id){
        return cityService.getCityById(id);
    }

    @PostMapping
    public void insertCity(@RequestBody City city){
        cityService.insertCity(city);
    }

    @PutMapping("{id}")
    public void updateCityById(@PathVariable Integer id, @RequestBody City city){
        cityService.updateCityById(id, city);
    }

    @DeleteMapping("{id}")
    public void deleteCityById(@PathVariable Integer id){
        cityService.deleteCityById(id);
    }


}
