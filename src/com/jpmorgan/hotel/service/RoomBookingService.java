package com.jpmorgan.hotel.service;



import java.util.Collection;

import com.jpmorgan.hotel.model.Rooms;
import com.jpmorgan.hotel.util.RoomBookingException;

/**
 * SRBS
 */
public interface RoomBookingService {
   
   
    public double quoteRoom(String id, String... facilities) throws RoomBookingException;

    public Collection<?> getAvailableRooms() throws RoomBookingException;

    public void addRoom(Rooms room) throws RoomBookingException;
   
}
