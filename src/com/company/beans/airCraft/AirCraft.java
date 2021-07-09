package com.company.beans.airCraft;

public class AirCraft {

    private float height;
    private float length;
    private float fuelCapacity;
    private float fuelConsumption;
    private float takeOffWeight;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public float getTakeOffWeight() {
        return takeOffWeight;
    }

    public void setTakeOffWeight(float takeOffWeight) {
        this.takeOffWeight = takeOffWeight;
    }

    public AirCraft(float height, float length, float fuelCapacity, float fuelConsumption, float takeOffWeight) {
        this.height = height;
        this.length = length;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.takeOffWeight = takeOffWeight;
    }

    public AirCraft() {
    }
}
