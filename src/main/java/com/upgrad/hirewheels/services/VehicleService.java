package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Vehicle;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();
    public List<Vehicle> getAvailableVehicles(String vehicleCategory, int locationId, Date pickupDate, Date dropOffDate);

}
