package com.jpmorgan.hotel.model;

import com.jpmorgan.hotel.util.RoomBookingConstants;



/**
 * GVR
 */
public class GreatViewRoom extends Rooms{
    

    /**
     *
     * @param id
     */
    public GreatViewRoom(String id,String type) {
        super(id,type);
    }

    
    /**
     *
     * @param facilities
     * @return
     */
    public double calculatePrice(String... facilities) {
        double price = 0;
        for(String facility : facilities){
            if(facility.equals(RoomBookingConstants.ROOM_BREAKFAST)){
                price = price + 5.0;
            } else if (facility.equals(RoomBookingConstants.ENSUITE_BATHROOM)){
                price = price + 4.0;
            } else if (facility.equals(RoomBookingConstants.INTERNET)){
                price = price + 2.0;
            } else if (facility.equals(RoomBookingConstants.LATE_CHECKOUT)){
                price = price + 1.0;
            } else if (facility.equals(RoomBookingConstants.SWIMMINGPOOL)){
                price = price + 1.0;
            }
        }
        return 2 * price;
    }
}
