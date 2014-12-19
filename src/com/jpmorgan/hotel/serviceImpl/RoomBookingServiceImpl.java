package com.jpmorgan.hotel.serviceImpl;





import java.util.Collection;

import com.jpmorgan.hotel.dao.RoomBookingDao;
import com.jpmorgan.hotel.model.Rooms;
import com.jpmorgan.hotel.service.RoomBookingService;
import com.jpmorgan.hotel.util.RoomBookingException;

/**
 * SRBS
 */
public class RoomBookingServiceImpl implements RoomBookingService{
    
	RoomBookingDao roomBookingDao = new RoomBookingDao();

    /**
     *
     * @param id
     * @param facilities
     * @return
     */
    @Override
    public double quoteRoom(String id, String... facilities) throws RoomBookingException
    {
    	return roomBookingDao.quoteRoom(id, facilities);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<?> getAvailableRooms() throws RoomBookingException{
        return roomBookingDao.getAvailableRooms();
    }

    /**
     *
     * @param room
     */
    @Override
    public void addRoom(Rooms room) throws RoomBookingException{
    	roomBookingDao.addRoom(room);
    }

    

}
