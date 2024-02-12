package com.malik.restfulcrud.service;

import com.malik.restfulcrud.exception.ResourceNotFoundException;
import com.malik.restfulcrud.model.Country;
import com.malik.restfulcrud.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {

    //No need to use @Autowired when using Constructor Injection
    //Dependencies are final
    //@Autowired
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryById(String id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not exist with id :" + id));
        return country;
    }

    public Country updateCountry(String id, Country countryDetails) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not exist with id :" + id));

        country.setName(countryDetails.getName());
        country.setCapital(countryDetails.getCapital());
        country.setCode(countryDetails.getCode());
        country.setPopulation(countryDetails.getPopulation());

        Country updatedCountry = countryRepository.save(country);
        return updatedCountry;
    }

    public Map<String, Boolean> deleteCountry(String id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not exist with id :" + id));

        countryRepository.delete(country);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
