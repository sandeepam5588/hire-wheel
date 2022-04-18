package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicle_subcategory")
public class VehicleSubcategory {
    @Id
    @Column(name = "vehicle_subcategory_id", length = 10, nullable = false)
    private int vehicleSubcategoryId;

    @Column(name = "vehicle_subcategory_name", length = 50, nullable = false, unique = true)
    private String vehicleSubcategoryName;

    @Column(name = "price_per_Day", length = 10, nullable = false)
    private int pricePerDay;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = false)
    private VehicleCategory vehicleCategory;

    @OneToMany(mappedBy = "vehicleSubcategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public VehicleSubcategory(){}

    public VehicleSubcategory(int vehicleSubcategoryId, String vehicleSubcategoryName, int pricePerDay, VehicleCategory vehicleCategory) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
        this.vehicleSubcategoryName = vehicleSubcategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategory = vehicleCategory;
    }

    public int getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicleSubcategoryId=" + vehicleSubcategoryId +
                ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }
}
