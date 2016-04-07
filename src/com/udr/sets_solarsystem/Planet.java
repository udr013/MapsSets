package com.udr.sets_solarsystem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by udr013 on 7-4-2016.
 */
public class Planet extends HeavenlyBody {
    private final Set<Moon> satellite =new HashSet<>();

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    public Set<Moon> getSatellite() {
        //satellite.add(moon);
       // System.out.println(moon.getName());
        return satellite;
    }

    public void addSatellites(Moon moon){
        satellite.add(moon);

    }

}
