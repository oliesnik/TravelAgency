package com.softserve.edu.service.impl;

import com.softserve.edu.model.Room;
import com.softserve.edu.service.RoomService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Override
    public boolean addRoom(Room room) {
        return false;
    }

    @Override
    public boolean addRoomToHotel(Room room) {
        return false;
    }

    @Override
    public List<Room> checkRoomsForPeriod(LocalDate from, LocalDate to) {
        return null;
    }
}
