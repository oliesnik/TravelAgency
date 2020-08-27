package com.softserve.edu.controller;

import com.softserve.edu.model.Person;
import com.softserve.edu.service.PersonService;
import com.softserve.edu.service.SecurityService;
import com.softserve.edu.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    private PersonService personService;
    private SecurityService securityService;
    private PersonValidator personValidator;

    @Autowired
    public PersonController(PersonService personService, SecurityService securityService, PersonValidator personValidator) {
        this.personService = personService;
        this.securityService = securityService;
        this.personValidator = personValidator;
    }

    @GetMapping({"/", "/home"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Person());

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") Person userForm, BindingResult bindingResult, Model model) {
 //       personValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        personService.save(userForm);
        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        return "redirect:/home";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping("/persons")
    public ModelAndView allUsers(){
        List<Person> persons = personService.getAll();
        ModelAndView mav = new ModelAndView("persons");
        mav.addObject("persons", persons);
        return mav;
    }

    @RequestMapping("/new_person")
    public String newCustomerForm(Map<String, Object> model) {
        Person person = new Person();
        model.put("person", person);
        return "new_person";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person) {
       // person.setRole(Person.Role.USER);
        personService.save(person);
        return "redirect:/persons";
    }

    @RequestMapping ("/persons/delete")
    public String deleteMarathon(@RequestParam long id) {
        personService.deletePersonById(id);
        return "redirect:/persons";
    }


}
