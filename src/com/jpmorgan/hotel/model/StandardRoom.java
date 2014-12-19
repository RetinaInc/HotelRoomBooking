package com.jpmorgan.hotel.model;



/**
 * STandardRoovm
 */
public class StandardRoom extends Rooms{
   
    /**
     *
     * @param id
     */
    public StandardRoom(String id,String type) {
        super(id,type);
    }

    /**
     *
     * @param facilities
     * @return
     */
    public double calculatePrice(String... facilities) {
        if(facilities.length > 3){
            return 3 * 3 + (facilities.length - 3) * 6;
        } else {
            return facilities.length * 3;
        }
    }

   
}
