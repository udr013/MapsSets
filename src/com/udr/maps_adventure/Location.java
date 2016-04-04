package com.udr.maps_adventure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by udr013 on 1-4-2016.
 */
public class Location {
    private final int loctionID;
    private final String description;
    private final Map<String, Integer>exits;

    public Location(int loctionID, String description,Map<String,Integer> exits) {
        this.loctionID = loctionID;
        this.description = description;
        if(exits!=null){
            this.exits = new HashMap<String, Integer>(exits);

        }else{
            this.exits= new HashMap<>();
        }
        exits.put("Q",0);

    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }

    public int getLoctionID() {
        return loctionID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return  new HashMap<String, Integer>(exits);
    }
}
