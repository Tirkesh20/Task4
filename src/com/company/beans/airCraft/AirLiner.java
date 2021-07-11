package com.company.beans.airCraft;

import com.company.enums.AirLineClasses;

import java.io.Serializable;

public class AirLiner extends AirCraft implements Serializable {

    private int passengerCapacity;
    private AirLineClasses airLineClasses;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public AirLineClasses getAirLineClasses() {
        return airLineClasses;
    }

    public void setAirLineClasses(AirLineClasses airLineClasses) {
        this.airLineClasses = airLineClasses;
    }

    public AirLiner(float height, float length, float fuelCapacity, float fuelConsumption, float takeOffWeight, int passengerCapacity, AirLineClasses airLineClasses) {
        super(height, length, fuelCapacity, fuelConsumption, takeOffWeight);
        this.passengerCapacity = passengerCapacity;
        this.airLineClasses = airLineClasses;
    }

    public AirLiner(float height, float length, float fuelCapacity, float fuelConsumption, float takeOffWeight, int passengerCapacity, int maxPassengerCapacity) {
        super(height, length, fuelCapacity, fuelConsumption, takeOffWeight);
        this.passengerCapacity = passengerCapacity;
    }

    public AirLiner(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public AirLiner() {
    }
}
