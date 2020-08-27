package com.softserve.edu.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Transient
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "roles")
    private Set<Person> persons;

    @Override
    public String getAuthority() {
        return getName();
    }
}