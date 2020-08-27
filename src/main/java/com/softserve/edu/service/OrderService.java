package com.softserve.edu.service;

import com.softserve.edu.model.Person;
import com.softserve.edu.model.Room;

public interface OrderService {

    boolean createOrder(Person person, Room room);


}
