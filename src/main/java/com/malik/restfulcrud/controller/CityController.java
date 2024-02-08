package com.malik.restfulcrud.controller;

import com.malik.restfulcrud.exception.ResourceNotFoundException;
import com.malik.restfulcrud.model.City;
import com.malik.restfulcrud.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    //get all cities
    @GetMapping("/cities")
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    // create city rest api
    @PostMapping("cities")
    public City createCity(@RequestBody City city){
        return cityRepository.save(city);
    }

    // get employee by id rest api
    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with id :" + id));
        return ResponseEntity.ok(city);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityDetails){
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with id :" + id));

        city.setName(cityDetails.getName());
        city.setCountryCode(cityDetails.getCountryCode());
        city.setDistrict(cityDetails.getDistrict());
        city.setPopulation(cityDetails.getPopulation());

        City updatedCity = cityRepository.save(city);
        return ResponseEntity.ok(updatedCity);
    }

    // delete employee rest api
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCity(@PathVariable Long id){
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with id :" + id));

        cityRepository.delete(city);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
