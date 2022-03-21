package com.example.parkproject.model;

import java.util.List;

public class Ticked {
    private Vehicle vehicle;
    private List<Integer> slots;

    public Ticked(Vehicle vehicle, List<Integer> slots) {
        this.vehicle = vehicle;
        this.slots = slots;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Integer> getSlots() {
        return slots;
    }

    public void setSlots(List<Integer> slots) {
        this.slots = slots;
    }
}
