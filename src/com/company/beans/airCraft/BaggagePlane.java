package com.company.beans.airCraft;

public class BaggagePlane extends AirCraft{

    private float baggageCapacity;
    private float maxBaggageCapacity;

    public float getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(float baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public float getMaxBaggageCapacity() {
        return maxBaggageCapacity;
    }

    public void setMaxBaggageCapacity(float maxBaggageCapacity) {
        this.maxBaggageCapacity = maxBaggageCapacity;
    }

    public BaggagePlane(float height, float length, float fuelCapacity,
                            float fuelConsumption, float takeOffWeight,
                                float baggageCapacity, float maxBaggageCapacity) {
        super(height, length, fuelCapacity, fuelConsumption, takeOffWeight);
        this.baggageCapacity = baggageCapacity;
        this.maxBaggageCapacity = maxBaggageCapacity;
    }

    public BaggagePlane(float baggageCapacity, float maxBaggageCapacity) {
        this.baggageCapacity = baggageCapacity;
        this.maxBaggageCapacity = maxBaggageCapacity;
    }

    public BaggagePlane() {
    }
}
