package com.softserve.edu.repository;

import com.softserve.edu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

   // List<Person> findAllByRoles;
    Person findPersonByEmail(String email);
}
