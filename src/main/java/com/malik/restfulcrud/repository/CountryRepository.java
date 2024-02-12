package com.malik.restfulcrud.repository;

import com.malik.restfulcrud.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}