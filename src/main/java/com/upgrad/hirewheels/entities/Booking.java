package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "booking_id", length = 10, nullable = false)
    private int bookingId;

    @Column(name = "pickup_date", nullable = false)
    private Date pickupDate;

    @Column(name = "drop_off_date", nullable = false)
    private Date dropOffDate;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "amount", length = 10, nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicleWithBooking;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Booking(){}

    public Booking(int bookingId, Date pickupDate, Date dropOffDate, Date bookingDate, double amount, Location location, Vehicle vehicleWithBooking, User user) {
        this.bookingId = bookingId;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.location = location;
        this.vehicleWithBooking = vehicleWithBooking;
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicleWithBooking() {
        return vehicleWithBooking;
    }

    public void setVehicleWithBooking(Vehicle vehicleWithBooking) {
        this.vehicleWithBooking = vehicleWithBooking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", pickupDate=" + pickupDate +
                ", dropOffDate=" + dropOffDate +
                ", bookingDate=" + bookingDate +
                ", amount=" + amount +
                ", location=" + location +
                ", vehicle=" + vehicleWithBooking +
                ", user=" + user +
                '}';
    }
}


