package com.udr.sets_solarsystem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by udr013 on 7-4-2016.
 */
public class Star extends HeavenlyBody  {
    private final Set<HeavenlyBody> starCompanions= new HashSet<>();
    public Star(String name) {
        super(name, 0);
    }

    public  void setStarCompanions(HeavenlyBody heavenlyBody) {
        starCompanions.add(heavenlyBody);
    }

    public  Set<HeavenlyBody> getStarCompanions() {
        return starCompanions;
    }
}
