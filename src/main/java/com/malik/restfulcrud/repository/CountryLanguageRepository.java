package com.malik.restfulcrud.repository;

import com.malik.restfulcrud.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
}