package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.VehicleCategoryDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleDao vehicleDao;

    @Autowired
    VehicleCategoryDao vehicleCategoryDao;

    @Autowired
    BookingDao bookingDao;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles(String vehicleCategory, int locationId, Date pickupDate, Date dropOffDate) {
        List<Vehicle> returnedVehicleList = new ArrayList<>();

        /**
         * Fetch a list of all vehicles of given vehicle category which are available in the desired location
         * and with availability_status = 1
         */
        vehicleCategoryDao.findByVehicleCategoryName(vehicleCategory).getVehicleSubcategories()
                .forEach(a -> a.getVehicles()
                        .forEach(b -> {
                            if(b.getLocation().getLocationId() == locationId && b.isAvailabilityStatus())
                                returnedVehicleList.add(b);
                        }));

        /**
         *  Get a list of all the vehicle Ids which have booking during input booking slot.
         *  A vehicle is unavailable for booking if any of the following three scenarios are met-
         *
         *  a. booking pick up date > Booked Vehicle's pickup date &&
         *  booking pick up date < Booked Vehicle's dropoff date
         *
         *  b. booking drop off date > Booked Vehicle's pickup date &&
         *  booking drop off date < Booked Vehicle's dropoff date
         *
         *  c. booking pickup date < Booked vehicle's pick up date &&
         *  booking drop off date > Booked vehicle's drop off date
         *
         * Apart from this, we also need to consider those vehicles as booked if booking pick or dropoff date
         * equals to either booked vehicle's pickup date or dropoff date.
         *
         */
        List<Integer> bookedVehicleIdList = new ArrayList<>();
        returnedVehicleList.forEach(a-> {
            List<Booking> bookedVehicleList = bookingDao.findByVehicleWithBooking(a);
            bookedVehicleList.forEach(b ->{
                if ((pickupDate.after(b.getPickupDate()) && pickupDate.before(b.getDropOffDate()))
                        || (dropOffDate.after(b.getPickupDate()) && dropOffDate.before(b.getDropOffDate()))
                        || (pickupDate.before(b.getPickupDate()) && dropOffDate.after(b.getDropOffDate()))
                        || pickupDate.equals(b.getDropOffDate())
                        || dropOffDate.equals(b.getPickupDate())
                        || pickupDate.equals(b.getPickupDate())
                        || dropOffDate.equals(b.getDropOffDate())){
                    bookedVehicleIdList.add(b.getVehicleWithBooking().getVehicleId());
                }
            });
        });

        /**
         * Filter out those vehicles from the returnedVehicleList
         * which are already booked in the booking slot.
         */
        List<Vehicle> availableVehicles = new ArrayList<>();
        returnedVehicleList.forEach(a-> {
            if(!bookedVehicleIdList.contains(a.getVehicleId() )){
                availableVehicles.add(a);
            }
        });
        return availableVehicles;
    }
}
