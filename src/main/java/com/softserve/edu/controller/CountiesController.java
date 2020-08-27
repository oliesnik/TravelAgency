package com.softserve.edu.controller;

import com.softserve.edu.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountiesController {

    private CountryService countryService;

    @Autowired
    public CountiesController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String getAll(Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "countries";
    }

    @RequestMapping ("/countries/delete")
    public String deleteMarathon(@RequestParam long id) {
        countryService.deleteCountryById(id);
        return "redirect:/countries";
    }


}
