package com.jpmorgan.hotel.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.hotel.model.GreatViewRoom;
import com.jpmorgan.hotel.model.Rooms;
import com.jpmorgan.hotel.model.StandardRoom;
import com.jpmorgan.hotel.model.SuiteRoom;
import com.jpmorgan.hotel.util.RoomBookingConstants;
import com.jpmorgan.hotel.util.RoomBookingException;

public class RoomBookingDao 
{
	
	private static final Map<String, Rooms> availableRooms;
	
	static {
		availableRooms = new HashMap<String, Rooms>();
		availableRooms.put(RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE, 
				new GreatViewRoom(RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE,RoomBookingConstants.HOTEL_GREATVIEW_ROOM_TYPE));
		availableRooms.put(RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE, 
				new StandardRoom(RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE,RoomBookingConstants.HOTEL_STANDARD_ROOM_TYPE));
		availableRooms.put(RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE, 
				new SuiteRoom(RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE,RoomBookingConstants.HOTEL_SUITE_ROOM_TYPE));
	}
	
	 
	    public double quoteRoom(String id, String... facilities) throws RoomBookingException
	    {	    	
	    	double quote=0.0;	    
	    	try
	    	{
	    	
		       	Object room = availableRooms.get(id);
				availableRooms.remove(id);
	
				if(room instanceof GreatViewRoom){
				    quote = ((GreatViewRoom)room).calculatePrice(facilities);
				}
				if(room instanceof StandardRoom){
					quote = ((StandardRoom)room).calculatePrice(facilities);
				}
				if(room instanceof SuiteRoom){
					quote = ((SuiteRoom)room).calculatePrice(facilities);
				}
		        
	    	}catch (Exception e) {
				throw new RoomBookingException("Exception in quoting Room Expense");
			}
	    	return quote;
	    }

	    /**
	     *
	     * @return
	     */
	    
	    public Collection<?> getAvailableRooms() throws RoomBookingException{
	        return availableRooms.values();
	    }

	    /**
	     *
	     * @param room
	     */
	    
	    public void addRoom(Rooms room) throws RoomBookingException{
	      availableRooms.put(room.getId(), room);
	    }

	   

}
