package org.example.service;

import java.util.HashSet;
import java.util.Set;

public class ParkingService {
    private Set<String> parkedCars;

    public ParkingService() {
        this.parkedCars = new HashSet<>();
    }

    public int getTotalParked() {
        return parkedCars.size();
    }

    public void park(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            return;
        }
        parkedCars.add(licensePlate.toUpperCase());
    }

    public void unpark(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            return;
        }
        parkedCars.remove(licensePlate.toUpperCase());
    }
}
