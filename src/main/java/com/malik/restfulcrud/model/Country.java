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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "continent")
    private String continent;

    @Column(name = "region")
    private String region;

    @Column(name = "surfacearea")
    private Long surfaceArea;

    @Column(name = "indepyear")
    private Long inDepYear;

    @Column(name = "population")
    private Long population;

    @Column(name = "lifeexpectancy")
    private Float lifeExpectancy;

    @Column(name = "gnp")
    private Long gnp;

    @Column(name = "gnpold")
    private Long gnpOld;

    @Column(name = "localname")
    private String localName;

    @Column(name = "governmentform")
    private String governmentForm;

    @Column(name = "headofstate")
    private String headOfState;

    @Column(name = "capital")
    private Integer capital;

    @Column(name = "code2")
    private String code2;

}