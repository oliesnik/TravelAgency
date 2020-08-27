package com.softserve.edu.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private Set<Room> rooms;
}
