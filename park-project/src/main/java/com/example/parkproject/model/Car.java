package com.example.parkproject.model;

public class Car extends Vehicle {

    public Car(String plate, String colour) {
        super(plate, colour);
    }

    @Override
    public int getRequiredSlots() {
        return 1;
    }

}