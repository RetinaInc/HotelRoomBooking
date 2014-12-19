package com.jpmorgan.hotel.util;



/*
 * Copyright © 2006-2010. BSkyB Ltd All Rights reserved
 */



public class RoomBookingException extends Exception {
		
	private static final long serialVersionUID = 1L;

	public RoomBookingException(String erroMessage)
	{
		super( (erroMessage!=null)?erroMessage:"");
		
	}
    
}
