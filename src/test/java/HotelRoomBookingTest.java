package test.java;



import java.util.Collection;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.hotel.model.Rooms;
import com.jpmorgan.hotel.model.StandardRoom;
import com.jpmorgan.hotel.service.RoomBookingService;
import com.jpmorgan.hotel.serviceImpl.RoomBookingServiceImpl;
import com.jpmorgan.hotel.util.RoomBookingConstants;
import com.jpmorgan.hotel.util.RoomBookingException;

	
public class HotelRoomBookingTest {
	
	private RoomBookingService roomBookingService;
	
	@Before
	public void setUp()
	{
		roomBookingService = new RoomBookingServiceImpl();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAvailableRooms() throws RoomBookingException
	{		
		Collection<Rooms> roomList = (Collection<Rooms>) roomBookingService.getAvailableRooms();
		Assert.assertNotNull(roomList);
	}
	
	@Test
	public void quoteStandardRoomFAILED() throws RoomBookingException
	{		
		double roomCharges = roomBookingService.quoteRoom("xyz",
				RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET,
				RoomBookingConstants.LATE_CHECKOUT,RoomBookingConstants.ROOM_BREAKFAST);
				
		Assert.assertFalse(roomCharges == 0.0);
	}
	
	@Test
	public void quoteStandardRoom() throws RoomBookingException
	{		
		double roomCharges = roomBookingService.quoteRoom(RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE,
				RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET,
				RoomBookingConstants.LATE_CHECKOUT,RoomBookingConstants.ROOM_BREAKFAST);
				
		Assert.assertFalse(roomCharges == 0.0);
	}
	
	@Test
	public void quoteSuiteRoom() throws RoomBookingException
	{
		double roomCharges = roomBookingService.quoteRoom(RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE,
					RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET);
		Assert.assertFalse(roomCharges == 0.0);
	}

	@Test
	public void quoteGreatView() throws RoomBookingException
	{
		double roomCharges = roomBookingService.quoteRoom(RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE,
				RoomBookingConstants.ENSUITE_BATHROOM,RoomBookingConstants.INTERNET);
		Assert.assertFalse(roomCharges == 0.0);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addStandardRoom() throws RoomBookingException
	{
		Rooms room = new StandardRoom(RoomBookingConstants.HOTEL_STANDARD_ROOM_REFERENCE, RoomBookingConstants.HOTEL_STANDARD_ROOM_TYPE);
		roomBookingService.addRoom(room);
		Collection<Rooms> roomList = (Collection<Rooms>) roomBookingService.getAvailableRooms();
		Assert.assertNotNull(roomList);		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addSuiteRoom() throws RoomBookingException
	{
		Rooms room = new StandardRoom(RoomBookingConstants.HOTEL_SUITE_ROOM_REFERENCE, RoomBookingConstants.HOTEL_SUITE_ROOM_TYPE);
		roomBookingService.addRoom(room);
		Collection<Rooms> roomList = (Collection<Rooms>) roomBookingService.getAvailableRooms();
		Assert.assertNotNull(roomList);	
	}

	@SuppressWarnings("unchecked")
	@Test
	public void addGreatView() throws RoomBookingException
	{
		Rooms room = new StandardRoom(RoomBookingConstants.HOTEL_GREATVIEW_ROOM_REFERENCE, RoomBookingConstants.HOTEL_GREATVIEW_ROOM_TYPE);
		roomBookingService.addRoom(room);
		Collection<Rooms> roomList = (Collection<Rooms>) roomBookingService.getAvailableRooms();
		Assert.assertNotNull(roomList);		
	}
	
	
	@After
	public void tearDown()
	{
		this.roomBookingService=null;
	}

}
