package com.malik.restfulcrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "country_language")
public class CountryLanguage {
    @Id
    @Column(name = "countrycode", nullable = false)
    private String countrycode;

    @Column(name = "language")
    private String language;

    @Column(name = "isofficial")
    private boolean isOfficial;

    @Column(name = "percentage")
    private float percentage;

}