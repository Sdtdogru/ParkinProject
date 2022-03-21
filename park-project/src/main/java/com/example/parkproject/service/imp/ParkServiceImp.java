package com.example.parkproject.service.imp;

import com.example.parkproject.common.ParkManager;
import com.example.parkproject.model.*;
import com.example.parkproject.service.ParkSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImp implements ParkSevice {


    @Override
    public String park(Request request) {

        Vehicle vehicle = buildVehicle(request.getPlate(),request.getColour(),request.getType());

        if(vehicle == null) {
            throw new RuntimeException("Vehicle can not be built");
        }

        return ParkManager.setSlot(vehicle);
    }

    @Override
    public List<Ticked> status() {
        return ParkManager.status();
    }

    @Override
    public String leave(int slot) {
        return ParkManager.leave(slot);
    }

    private Vehicle buildVehicle(String plate, String colour, String type) {
        Vehicle vehicle = null;
        switch (type) {
            case "Car":
                vehicle = new Car(plate, colour);
                break;
            case "Jeep":
                vehicle = new Jeep(plate, colour);
                break;
            case "Truck":
                vehicle = new Truck(plate, colour);
                break;
        }

        return vehicle;
    }
}
