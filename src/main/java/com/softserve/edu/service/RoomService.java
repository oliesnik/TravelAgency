package com.softserve.edu.service;

import com.softserve.edu.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    boolean addRoom(Room room);
    boolean addRoomToHotel(Room room);
    List<Room> checkRoomsForPeriod(LocalDate from, LocalDate to);
}
