package com.softserve.edu.service;

import com.softserve.edu.model.Person;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    //  List<Person> getAllByRole(String role);
    Person getPersonById(long id);

    void save(Person person);

    boolean addPerson(Person person);

    boolean editPerson(Person person);

    void deletePersonById(long id);

    Person createOrUpdateUser(Person entity);

    UserDetails loadUserByUsername(String email);

    Person findByEmail(String email);

    //boolean addUserToOrder(Person person, Order order);
}
