package com.softserve.edu.controller;

import com.softserve.edu.model.Country;
import com.softserve.edu.model.Hotel;
import com.softserve.edu.model.Person;
import com.softserve.edu.service.CountryService;
import com.softserve.edu.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class HotelController {

    private HotelService hotelService;
    private CountryService countryService;

    @Autowired
    public HotelController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("/hotels")
    public String getAll(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }

    @GetMapping("/new_hotel")
    public String createHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "new_hotel";
    }

    @PostMapping(value = "/saveHotel")
    public String savePerson(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.save(hotel);
        return "hotels";
    }

    @RequestMapping("/hotelsByCountry")
    public String getAllHotelsByCountry(@RequestParam long id, Model model) {
        Country country = countryService.getCountryById(id);
        model.addAttribute("hotels", hotelService.getAllHotelsByCountry(country));
        return "hotels";
    }

//    @PostMapping("/hotels/{marathon_id}/add")
//    public String createStudent(@PathVariable("marathon_id") long marathonId, @Validated @ModelAttribute User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "create-student";
//        }
//        userService.addUserToMarathon(
//                userService.createOrUpdateUser(user),
//                marathonService.getMarathonById(marathonId));
//        return "redirect:/students/" + marathonId;
//    }
//
//    @GetMapping("/hotels/{marathon_id}/add")
//    public String createStudent(@RequestParam("user_id") long userId, @PathVariable("marathon_id") long marathonId) {
//        userService.addUserToMarathon(
//                userService.getUserById(userId),
//                marathonService.getMarathonById(marathonId));
//        return "redirect:/students/" + marathonId;
//    }
}
