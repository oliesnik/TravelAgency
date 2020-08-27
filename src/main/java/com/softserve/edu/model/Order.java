package com.softserve.edu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Person user;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Room> rooms;

}
