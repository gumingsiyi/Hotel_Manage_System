package com.service;

import com.model.Hotel;
import com.model.Room;

import java.util.List;

/**
 * Created by stiles on 15/12/28.
 */
public interface RoomService {
    boolean add(Room room);
    Room findOne(String id);
    int findRoomsSize();
    List findAll(int pageNow, int pageSize);
    List findRoomsByHotel(Hotel hotel);
    boolean remove(String id);
    boolean update(Room room);
    List findRoomsByCity(String city, int pageNow, int pageSize);
}
