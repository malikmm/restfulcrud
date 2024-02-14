package com.malik.restfulcrud.service;

import com.malik.restfulcrud.model.Country;
import com.malik.restfulcrud.repo.CountryModelTest;
import com.malik.restfulcrud.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @Test
    void getAllCounties(){
        Country country = new Country("ABC", "Dave", "Asia", "", 0L,0L,0L,0.0F,0L,0L,"","","",1,"" );
        Country country2 = new Country("CDE", "Liu", "Africa", "", 0L,0L,0L,0.0F,0L,0L,"","","",1,"");

        given(countryRepository.findAll())
                .willReturn(List.of(country,country2));

        var countryList = countryService.getAllCountries();
        //Then
        //Make sure to import assertThat From org.assertj.core.api package
        assertThat(countryList).isNotNull();
        assertThat(countryList.size()).isEqualTo(2);

    }
}
