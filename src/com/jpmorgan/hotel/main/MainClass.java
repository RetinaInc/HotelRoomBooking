package com.jpmorgan.hotel.main;


import java.util.Collection;

import com.jpmorgan.hotel.model.Rooms;
import com.jpmorgan.hotel.model.StandardRoom;
import com.jpmorgan.hotel.service.RoomBookingService;
import com.jpmorgan.hotel.serviceImpl.RoomBookingServiceImpl;
import com.jpmorgan.hotel.util.RoomBookingConstants;
import com.jpmorgan.hotel.util.RoomBookingException;

/**
 * The class is to see all the data returned by different methods
 *
 **/
public class MainClass 
{
	static RoomBookingService roomBookingService = new RoomBookingServiceImpl();
	
	public static void main(String[] args) 
	{		
		
		try {
			getAvailableRooms();
			quoteStandardRoom();
			quoteSuiteRoom();
			quoteGreatView();
			addStandardRoom();
			addSuiteRoom();
			addGreatView();
		} catch (RoomBookingException e) {
			
			e.printStackTrace();
		}
	}
	

	@SuppressWarnings("unchecked")
	public static void getAvailableRooms() throws RoomBookingException
	{
		System.out.println("------------- Available Rooms -------------");
		Collection<Rooms> roomList = (Collection<Rooms>) roomBookingService.getAvailableRooms();
		for(Rooms room:roomList)
		{
			System.out.println(room.getId() + " :: " + room.getType());
		}
		System.out.println("-------------------------------------------");
	}
	
	
	public static void quoteStandardRoom() throws RoomBookingException
	{
		double roomCharges = roomBookingService.quoteRoom(RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE,
				RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET,
				RoomBookingConstants.LATE_CHECKOUT,RoomBookingConstants.ROOM_BREAKFAST);		
		System.out.println("Standard Room quote : " + roomCharges);	
		getAvailableRooms();
		
	}
	
	
	public static void quoteSuiteRoom() throws RoomBookingException
	{
		double roomCharges = roomBookingService.quoteRoom(RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE,
					RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET);		
		System.out.println("Suite Room quote : " + roomCharges);	
		getAvailableRooms();
	}

	
	public static void quoteGreatView() throws RoomBookingException
	{
		double roomCharges = roomBookingService.quoteRoom(RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE,
				RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET);			
		System.out.println("Great View Room quote : " + roomCharges);
		getAvailableRooms();
	}
	
	
	public static void addStandardRoom() throws RoomBookingException
	{
		Rooms room = new StandardRoom(RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE, RoomBookingConstants.HOTEL_STANDARD_ROOM_TYPE);
		roomBookingService.addRoom(room);
		System.out.println("Standard Room Added :: " + RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE);
		getAvailableRooms();
				
	}
	
		
	public static void addSuiteRoom() throws RoomBookingException
	{
		Rooms room = new StandardRoom(RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE, RoomBookingConstants.HOTEL_SUITE_ROOM_TYPE);
		roomBookingService.addRoom(room);
		System.out.println("Suite Room Added :: " + RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE);
		getAvailableRooms();
		
	}

	
	public static void addGreatView() throws RoomBookingException
	{
		Rooms room = new StandardRoom(RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE, RoomBookingConstants.HOTEL_GREATVIEW_ROOM_TYPE);
		roomBookingService.addRoom(room);
		System.out.println("Great View Room Added :: " + RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE);
		getAvailableRooms();				
	}


}
