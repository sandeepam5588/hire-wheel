package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "fuel_type")
public class FuelType {

    @Id
    @Column(name = "fuel_type_id",length = 10, nullable = false)
    private int fuelTypeId;

    @Column(name = "fuel_type",length = 50, nullable = false, unique = true)
    private String fuelType;

    @OneToMany(mappedBy = "fuelType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public FuelType(){}

    public FuelType(int fuelTypeId, String fuelType, Set<Vehicle> vehicles) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
        this.vehicles = vehicles;
    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
