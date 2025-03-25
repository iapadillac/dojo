package org.example.service;

import java.util.HashSet;
import java.util.Set;

public class ParkingService {
    private final Set<String> parkedCars;

    public ParkingService() {
        this.parkedCars = new HashSet<>();
    }

    public int getTotalParked() {
        return parkedCars.size();
    }

    public void park(String licensePlate) {
        if (isValidLicensePlate(licensePlate)) {
            return;
        }
        parkedCars.add(licensePlate.replace("-", "").toUpperCase());
    }

    public void unpark(String licensePlate) {
        if (isValidLicensePlate(licensePlate)) {
            return;
        }
        parkedCars.remove(licensePlate.replace("-", "").toUpperCase());
    }

    private boolean isValidLicensePlate(String licensePlate) {
        return licensePlate == null || licensePlate.trim().isEmpty() ||
                !licensePlate.matches("^[A-Z]{3}-?\\d{4}$") ||
                licensePlate.contains("--");
    }

}
