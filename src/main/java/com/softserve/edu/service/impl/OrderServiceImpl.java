package com.softserve.edu.service.impl;

import com.softserve.edu.model.Person;
import com.softserve.edu.model.Room;
import com.softserve.edu.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Override
    public boolean createOrder(Person person, Room room) {
        return false;
    }
}
