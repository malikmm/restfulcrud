package com.malik.restfulcrud.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;


@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CountryModelTest {
    @Id
    private String code;
    private String name;
    private String continent;
//    private String region;
//    private Long surfaceArea;
//    private Long inDepYear;
//    private Long population;
//    private Float lifeExpectancy;
//    private Long gnp;
//    private Long gnpOld;
//    private String localName;
//    private String governmentForm;
//    private String headOfState;
//    private Integer capital;
//    private String code2;
}
