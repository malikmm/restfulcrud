package com.malik.restfulcrud.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "countrycode")
    private String countryCode;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private double population;

    public City() {
    }

    public City(String name, String countryCode, String district, double population) {
        super();
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }
}
