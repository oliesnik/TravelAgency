package com.softserve.edu.service.impl;

import com.softserve.edu.model.Person;
import com.softserve.edu.model.Role;
import com.softserve.edu.repository.PersonRepository;
import com.softserve.edu.repository.RoleRepository;
import com.softserve.edu.service.PersonService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

@Service
public class PersonServiceImpl implements PersonService, UserDetailsService {

    final private PersonRepository personRepository;
    final private RoleRepository roleRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = personRepository.findAll();
        return persons.isEmpty() ? new ArrayList<>() : persons;
    }

//    @Override
//    public List<Person> getAllByRole(String role) {
//        return personRepository.getAllByRole(Person.Role.valueOf(role.toUpperCase()));
//    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new EntityNotFoundException("No person with such id!");
        }
    }

    @Override
    public boolean addPerson(Person person) {
        return false;
    }

    @Override
    public boolean editPerson(Person person) {
        return false;
    }

    @Override
    public void deletePersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No person with such id");
        }
    }


    public void save(Person person) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        person.setRoles(roles);
        personRepository.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = personRepository.findPersonByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : person.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(person.getUsername(), person.getPassword(), grantedAuthorities);
    }

    @Override
    public Person findByEmail(String email) {
        Optional<Person> person = Optional.ofNullable(personRepository.findPersonByEmail(email));
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new EntityNotFoundException("No person with such email!");
        }
    }

    @Override
    public Person createOrUpdateUser(Person entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(entity);
        if(!violations.isEmpty()){
            throw new RuntimeException(violations.toString());
        }
        if (entity.getId() != null) {
            Optional<Person> user = personRepository.findById(entity.getId());
            if (user.isPresent()) {
                Person newUser = user.get();
                newUser.setEmail(entity.getEmail());
                newUser.setFirstName(entity.getFirstName());
                newUser.setLastName(entity.getLastName());
              //  newUser.setRole(entity.getRole());
                newUser.setPassword(entity.getPassword());
                newUser = personRepository.save(newUser);
                return newUser;
            }
        }
        entity = personRepository.save(entity);
        return entity;
    }


}
