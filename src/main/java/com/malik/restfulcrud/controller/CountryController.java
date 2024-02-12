package com.malik.restfulcrud.controller;

import com.malik.restfulcrud.model.Country;
import com.malik.restfulcrud.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    //get all countries
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries(){
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    // create country rest api
    @PostMapping("countries")
    public Country createCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    // get employee by id rest api
    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable String id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable String id, @RequestBody Country countryDetails){
        Country country = countryService.updateCountry(id,countryDetails);
        return ResponseEntity.ok(country);
    }

    // delete employee rest api
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCountry(@PathVariable String id){
        Map<String, Boolean> response = countryService.deleteCountry(id);
        return ResponseEntity.ok(response);
    }

}
