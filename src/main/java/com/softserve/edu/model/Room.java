package com.softserve.edu.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @CreationTimestamp
    private LocalDate bookingStarts;

    @CreationTimestamp
    private LocalDate bookingEnds;

    private boolean isBooked;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

}
