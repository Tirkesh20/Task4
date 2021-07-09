package com.company.beans;

import com.company.beans.airCraft.AirLiner;
import com.company.beans.airCraft.BaggagePlane;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Airlines {

    private Set<AirLiner> airLiners=new HashSet<>();
    private Set<BaggagePlane> baggagePlanes=new HashSet<>();

    public boolean addAirliner(AirLiner airLiner){
        return airLiners.add(airLiner);
    }

    public boolean addBaggagePlane(BaggagePlane baggagePlane){
        return baggagePlanes.add(baggagePlane);
    }

    public boolean deleteAirliner(AirLiner airLiner){
        return airLiners.remove(airLiner);
    }

    public boolean deleteBaggagePlane(BaggagePlane baggagePlane){
        return baggagePlanes.remove(baggagePlane);
    }

    public Iterator<AirLiner> airLinerIterator(){
        return  airLiners.iterator();
    }

    public Iterator<BaggagePlane> baggagePlaneIterator(){
        return baggagePlanes.iterator();
    }



}
