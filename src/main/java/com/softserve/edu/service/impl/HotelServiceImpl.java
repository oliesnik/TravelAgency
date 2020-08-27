package com.softserve.edu.service.impl;

import com.softserve.edu.model.Country;
import com.softserve.edu.model.Hotel;
import com.softserve.edu.repository.CountryRepository;
import com.softserve.edu.repository.HotelRepository;
import com.softserve.edu.service.HotelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    final private HotelRepository hotelRepository;
    final private CountryRepository countryRepository;

    public HotelServiceImpl(HotelRepository hotelRepository, CountryRepository countryRepository) {
        this.hotelRepository = hotelRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.isEmpty() ? new ArrayList<>() : hotels;
    }

    @Override
    public List<Hotel> getAllHotelsByCountry(Country country) {
        List<Hotel> hotels = hotelRepository.getHotelsByCountry(country);
        return hotels.isEmpty() ? new ArrayList<>() : hotels;
    }

    @Override
    public boolean save(Hotel hotel) {
        return false;
    }

    @Override
    public boolean addHotelToCountry(Hotel hotel, Country country) {
        Hotel hotelEntity = hotelRepository.getOne(hotel.getId());
        Country countryEntity = countryRepository.getOne(country.getId());
        countryEntity.getHotels().add(hotelEntity);
        countryRepository.save(countryEntity);
        return true;
    }

    @Override
    public boolean remove(Hotel hotel) {
        return false;
    }
}
