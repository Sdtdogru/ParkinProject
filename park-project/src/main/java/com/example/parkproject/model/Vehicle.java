package com.example.parkproject.model;

import java.util.List;

public abstract class Vehicle {

    private String plate;
    private String colour;

    public Vehicle(String plate, String colour) {
        this.plate = plate;
        this.colour = colour;
    }

    public abstract int getRequiredSlots();

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return plate + " " + colour;
    }
}
