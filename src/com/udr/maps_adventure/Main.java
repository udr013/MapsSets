package com.udr.maps_adventure;

import java.util.*;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

	// write your code here
        Scanner scanner = new Scanner(System.in);

        // constructor of location has: int locationID, String description as parameters
        HashMap<String, Integer> tempExit= new HashMap<>();
        locations.put(0 , new Location(0,"You are in front of a computer learning Java", null));

        tempExit= new HashMap<>();
        tempExit.put("N",5);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("W",2);
        locations.put(1 , new Location(1,"You are standing at the end of a road before a small brick building",tempExit));

        tempExit= new HashMap<>();
        tempExit.put("N",5);
        locations.put(2 , new Location(2,"You are at the top of the hill",tempExit));

        tempExit= new HashMap<>();
        tempExit.put("W",1);
        locations.put(3 , new Location(3,"You are inside a building, a well house for a small spring",tempExit));

        tempExit= new HashMap<>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4 , new Location(4,"You are in a valley beside a stream",tempExit));

        tempExit= new HashMap<>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5 , new Location(5,"You are in the forest",tempExit));

        Map<String, String>stringprocesser=new HashMap<>();
        stringprocesser.put("QUIT","Q");
        stringprocesser.put("NORTH", "N");
        stringprocesser.put("EAST", "E");
        stringprocesser.put("SOUTH","S");
        stringprocesser.put("WEST","W");

        int loc = 1;

        while(true){
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            if (loc==0){
                break;
            }

            Map<String, Integer> exits= locations.get(loc).getExits();
            System.out.println("Available exits are:");

            //exits.keySet().forEach(System.out::println);
            for(String exit: exits.keySet()){
                System.out.println(exit+ ",");
            }

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length()>1){
                String[]words = direction.split(" ");
                for(String word: words){
                    if(stringprocesser.containsKey(word)){
                        direction=stringprocesser.get(word);
                        break;
                    }
                }

            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }else{
                System.out.println("You can't go in that direction");
            }
        }

    }
}
