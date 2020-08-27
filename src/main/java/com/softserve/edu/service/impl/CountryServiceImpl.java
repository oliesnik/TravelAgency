package com.softserve.edu.service.impl;

import com.softserve.edu.model.Country;
import com.softserve.edu.repository.CountryRepository;
import com.softserve.edu.service.CountryService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    final private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        List<Country> countries = countryRepository.findAll();
        return countries.isEmpty() ? new ArrayList<>() : countries;
    }

    @Override
    public Country getCountryById(Long countryId) {
        Optional<Country> country = countryRepository.findById(countryId);
        if (country.isPresent()) {
            return countryRepository.getOne(countryId);
        } else {
            throw new EntityNotFoundException("No country with such id");
        }
    }

    @Override
    public boolean addCountry(Country country) {
        return false;
    }

    @Override
    public void deleteCountryById(long countryId) {
        Optional<Country> country = countryRepository.findById(countryId);
        if (country.isPresent()) {
            countryRepository.deleteById(countryId);
        } else {
            throw new EntityNotFoundException("No country with such id");
        }
    }


}
