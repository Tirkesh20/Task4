package com.company.beans.airCraft;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "BaggagePlane{" +
                "baggageCapacity=" + baggageCapacity +
                ", maxBaggageCapacity=" + maxBaggageCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaggagePlane that = (BaggagePlane) o;
        return Float.compare(that.baggageCapacity, baggageCapacity) == 0 && Float.compare(that.maxBaggageCapacity, maxBaggageCapacity) == 0;
    }

    @Override
    public int hashCode() {
        int result=5;
        result=result*12+Double.hashCode(baggageCapacity);
        result=result*12+Double.hashCode(maxBaggageCapacity);
        return result;
    }
}
