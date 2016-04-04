package com.udr.sets_solarsystem;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by udr013 on 4-4-2016.
 */
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();

    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return satellites.add(moon);

    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        System.out.println("object get class = " + o.getClass());
        System.out.println("this object get class = " + this.getClass());
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        String objectName = ((HeavenlyBody) o).getName();
        return this.name.equals(objectName);

        }

    @Override
    public int hashCode() {
        System.out.println("hashcode called:"+ this.name + this.name.hashCode());
        return this.name.hashCode()+57;
        //return 0; the easy way out
    }

}


/**
 * auto generated equals and hashcode overrides
 */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        HeavenlyBody body = (HeavenlyBody) o;
//
//        if (Double.compare(body.orbitalPeriod, orbitalPeriod) != 0) return false;
//        if (name != null ? !name.equals(body.name) : body.name != null) return false;
//        return satellites != null ? satellites.equals(body.satellites) : body.satellites == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = name != null ? name.hashCode() : 0;
//        temp = Double.doubleToLongBits(orbitalPeriod);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (satellites != null ? satellites.hashCode() : 0);
//        return result;
//    }
