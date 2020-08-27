package com.softserve.edu.service;

import com.softserve.edu.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();
    Country getCountryById(Long countryId);
    boolean addCountry(Country country);
    void deleteCountryById(long countryId);


}
