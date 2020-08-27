package com.softserve.edu.service;

import com.softserve.edu.model.Country;
import com.softserve.edu.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();
    List<Hotel> getAllHotelsByCountry(Country country);
    boolean save(Hotel hotel);
    boolean addHotelToCountry(Hotel hotel, Country country);
    boolean remove(Hotel hotel);

}
