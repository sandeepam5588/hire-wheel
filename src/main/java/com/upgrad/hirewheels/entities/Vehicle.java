package com.upgrad.hirewheels.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "vehicle_id",length = 10, nullable = false)
    private int vehicleId;

    @Column(name = "vehicle_model",length = 50, nullable = false)
    private String vehicleModel;

    @Column(name = "vehicle_number",length = 10, nullable = false)
    private String vehicleNumber;

    @Column(name = "color",length = 50, nullable = false)
    private String color;

    @Column(name = "availability_status",length = 1, nullable = false)
    private boolean availabilityStatus;

    @Column(name = "vehicle_image_url",length = 500, nullable = false)
    private String vehicleImageUrl;

    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_idr", nullable = false)
    @JsonBackReference
    private VehicleSubcategory vehicleSubcategory;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    @JsonBackReference
    private Location location;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    @JsonBackReference
    private FuelType fuelType;

    @OneToMany(mappedBy = "vehicleWithBooking", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Booking> bookings;

    public Vehicle(){}

    public Vehicle(int vehicleId, String vehicleModel, String vehicleNumber, String color, boolean availabilityStatus, String vehicleImageUrl, VehicleSubcategory vehicleSubcategory, Location location, FuelType fuelType, Set<Booking> bookings) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availabilityStatus = availabilityStatus;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleSubcategory = vehicleSubcategory;
        this.location = location;
        this.fuelType = fuelType;
        this.bookings = bookings;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getVehicleImageUrl() {
        return vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", color='" + color + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                ", vehicleImageUrl='" + vehicleImageUrl + '\'' +
                ", vehicleSubcategory=" + vehicleSubcategory +
                ", location=" + location +
                ", fuelType=" + fuelType +
                '}';
    }
}
