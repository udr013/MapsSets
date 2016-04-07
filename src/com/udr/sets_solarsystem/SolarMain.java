package com.udr.sets_solarsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by udr013 on 4-4-2016.
 */
public class SolarMain {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Planet>planets = new HashSet<>();

    public static void main(String[] args) {
        Planet mercury = new Planet("Mercury", 88);
        solarSystem.put(mercury.getName(), mercury);
        planets.add(mercury);

        Planet venus = new Planet("Venus", 255);
        solarSystem.put(venus.getName(), venus);
        planets.add(venus);

        Planet earth = new Planet("Earth", 365);
        solarSystem.put(earth.getName(), earth);
        planets.add(earth);

        Moon moon = new Moon("Moon", 27);
        solarSystem.put(moon.getName(), moon);
        earth.addSatellites(moon);


        Planet mars = new Planet("Mars", 687);
        solarSystem.put(mars.getName(), mars);
        planets.add(mars);

        Moon deimos = new Moon("Deimos", 1.3);
        solarSystem.put(deimos.getName(), deimos);
        mars.addSatellites(deimos); // temp is still Mars

        Moon phobos = new Moon("Phobos", 0.3);
        solarSystem.put(phobos.getName(), phobos);
        mars.addSatellites(phobos); // temp is still Mars

        Planet jupiter = new Planet("Jupiter", 4332);
        solarSystem.put(jupiter.getName(), jupiter);
        planets.add(jupiter);

        Moon io = new Moon("Io", 1.8);
        solarSystem.put(io.getName(), io);
        jupiter.addSatellites(io); // temp is still Jupiter

        Moon europa = new Moon("Europa", 3.5);
        solarSystem.put(europa.getName(), europa);
        jupiter.addSatellites(europa); // temp is still Jupiter

        Moon ganymede = new Moon("Ganymede", 7.1);
        solarSystem.put(ganymede.getName(), ganymede);
        jupiter.addSatellites(ganymede); // temp is still Jupiter

        Moon callisto= new Moon("Callisto", 16.7);
        solarSystem.put(callisto.getName(), callisto);
        jupiter.addSatellites(callisto); // temp is still Jupiter

        Planet saturn= new Planet("Saturn", 10759);
        solarSystem.put(saturn.getName(), saturn);
        planets.add(saturn);

        Planet uranus = new Planet("Uranus", 30660);
        solarSystem.put(uranus.getName(), uranus);
        planets.add(uranus);

        Planet neptune = new Planet("Neptune", 165);
        solarSystem.put(neptune.getName(), neptune);
        planets.add(neptune);

        Planet pluto= new Planet("Pluto", 248);
        solarSystem.put(pluto.getName(), pluto);
        planets.add(pluto);

        Star sun = new Star("Sun");
        solarSystem.put(sun.getName(),sun);
        sun.setStarCompanions(mercury);
        sun.setStarCompanions(earth);
        sun.setStarCompanions(neptune);
        sun.setStarCompanions(jupiter);
        sun.setStarCompanions(venus);
        sun.setStarCompanions(pluto);
        sun.setStarCompanions(uranus);
        sun.setStarCompanions(saturn);
        sun.setStarCompanions(mars);

        Comet pluto2 = new Comet("Pluto", 80000);
        sun.setStarCompanions(pluto2);
        solarSystem.put(pluto2.getName(),pluto2);

        System.out.println("Star");
        System.out.print(sun.getName()+": ");
        for(HeavenlyBody x:sun.getStarCompanions()){
            if(x instanceof Planet) {
                System.out.print(x.getName() + ",");
            }

        }
        System.out.println();

        System.out.print(sun.getName()+": ");
        for(HeavenlyBody x:sun.getStarCompanions()){
            if(x instanceof Comet) {
                System.out.print(x.getName() + ",");
            }

        }


        System.out.println("\nPlanets:");
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName());
        }

        System.out.println("\nMoons:");
        for (Planet planet : planets) {
            if(planet.getSatellite().size()>0) {
                System.out.print("\n" + planet.getName() + ": ");
                for (Moon m : planet.getSatellite()) {
                    System.out.print(m.getName() + ", ");
                }
            }

        }System.out.println();


//        System.out.println("\nMoons of " + body.getName());
//        for (HeavenlyBody x : solarSystem<String,HeavenlyBody>Moon) {
//            System.out.println(moon.getName());
//
//        }

//        Set<HeavenlyBody> moons = new HashSet<>();
//        for (HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites());
//        }
//        System.out.println("\nAll Moons:");
//        for(HeavenlyBody moon: moons){
//            System.out.println(moon.getName());
//        }
//
//        temp = new HeavenlyBody("Pluto", 842);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);

        //will print pluto twice as equals method is not overridden
        System.out.println("\nPlanets:");
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName()+ ":"+ planet.getOrbitalPeriod());
        }
        System.out.println("\nall heavenlyBodies:");
       for(HeavenlyBody h:solarSystem.values()){
           System.out.println(h.getClass()+": "+h.getName());
       }
}




    }

