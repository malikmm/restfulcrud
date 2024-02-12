package com.malik.restfulcrud.controller;

import com.malik.restfulcrud.exception.ResourceNotFoundException;
import com.malik.restfulcrud.model.Country;
import com.malik.restfulcrud.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    //get all countries
    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    // create country rest api
    @PostMapping("countries")
    public Country createCountry(@RequestBody Country country){
        return countryRepository.save(country);
    }

    // get employee by id rest api
    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable String id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not exist with id :" + id));
        return ResponseEntity.ok(country);
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable String id, @RequestBody Country countryDetails){
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not exist with id :" + id));

        country.setName(countryDetails.getName());
        country.setCapital(countryDetails.getCapital());
        country.setCode(countryDetails.getCode());
        country.setPopulation(countryDetails.getPopulation());

        Country updatedCountry = countryRepository.save(country);
        return ResponseEntity.ok(updatedCountry);
    }

    // delete employee rest api
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCountry(@PathVariable String id){
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not exist with id :" + id));

        countryRepository.delete(country);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
