package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        Vehicle checkVehicle = vehicleDao.findByVehicleNumber(vehicle.getVehicleNumber());
        if (checkVehicle != null){
            System.out.println("Vehicle Number already exists");
            return checkVehicle;
        }
        vehicle.setAvailabilityStatus(true);
        return vehicleDao.save(vehicle);
    }

    @Override
    public Vehicle changeAvailabilityStatus(int vehicleId, boolean availabilityStatus) {
        Vehicle retrievedVehicle = vehicleDao.findById(vehicleId).get();
        if (retrievedVehicle == null){
            System.out.println("Vehicle with id "+vehicleId+" does not exist");
            return retrievedVehicle;
        }
        retrievedVehicle.setAvailabilityStatus(availabilityStatus);
        return vehicleDao.save(retrievedVehicle);
    }
}
