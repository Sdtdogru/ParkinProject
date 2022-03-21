package com.example.parkproject.common;

import com.example.parkproject.model.Ticked;
import com.example.parkproject.model.Vehicle;

import java.util.*;

public final class ParkManager {

    public static Map<Integer, Ticked> carMAp = new HashMap<Integer, Ticked>();
    static int[] slots = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String setSlot(Vehicle v) {
        int type = v.getRequiredSlots();
        int count = 0;
        String returnValue = "";
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == 0) {
                count++;
                if (count == type) {
                    returnValue = add(v, i, type);
                    System.out.println("Add Slot.");
                    break;
                }
            } else {
                if (i == slots.length - type) {
                    System.out.println("Garage is full.");
                    returnValue = "Garage is full.";
                }
                count = 0;
            }
        }
        return returnValue;
    }

    public static String add(Vehicle vehicle, int i, int k) {

        List<Integer> list = new ArrayList<>();

        for (int j = k - 1; j >= 0; j--) {
            slots[i - j] = 1;
            list.add(i - j + 1);
        }

        Ticked ticked = new Ticked(vehicle, list);
        carMAp.put(i - k + 2, ticked);
        System.out.println("Allocated " + k + " slot.");
        return "Allocated " + k + " slot.";

    }

    public static String leave(int slot) {

        try {
            int count = 0;
            for (Map.Entry<Integer, Ticked> set : carMAp.entrySet()) {
                count++;
                if (count == slot) {
                    for (int i = 0; i < carMAp.get(set.getKey()).getSlots().size(); i++) {
                        slots[carMAp.get(set.getKey()).getSlots().get(i) - 1] = 0;
                    }
                    carMAp.remove(set.getKey());
                }
            }
            if (count==0)
                return "slot is null";

        } catch (ConcurrentModificationException er) {
            System.out.println("leave "+slot);
        }
        return "leave "+slot;
    }

    public static List<Ticked> status() {
        List<Ticked> tickeds = new ArrayList<>();

        for (Map.Entry<Integer, Ticked> set : carMAp.entrySet()) {
            tickeds.add(set.getValue());
        }
        return tickeds;
    }

}
