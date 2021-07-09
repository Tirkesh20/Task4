package com.company.beans.airCraft;

public class AirLiner extends AirCraft{

    private int passengerCapacity;
    private int maxPassengerCapacity;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }

    public void setMaxPassengerCapacity(int maxPassengerCapacity) {
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public AirLiner(float height, float length, float fuelCapacity, float fuelConsumption, float takeOffWeight, int passengerCapacity, int maxPassengerCapacity) {
        super(height, length, fuelCapacity, fuelConsumption, takeOffWeight);
        this.passengerCapacity = passengerCapacity;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public AirLiner(int passengerCapacity, int maxPassengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public AirLiner() {
    }
}
