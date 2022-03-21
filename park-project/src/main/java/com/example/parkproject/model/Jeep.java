package com.example.parkproject.model;

public class Jeep extends Vehicle {

    public Jeep(String plate, String colour) {
        super(plate, colour);
    }

    @Override
    public int getRequiredSlots() {
        return 2;
    }

}
