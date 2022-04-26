package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.FuelTypeDao;
import com.upgrad.hirewheels.dao.LocationDao;
import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.VehicleSubcategoryDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HireWheelsApplication{

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		RoleDao roleDao = context.getBean(RoleDao.class);
		LocationDao locationDao = context.getBean(LocationDao.class);

		/* Test UserService and RoleDao */
		User user1 = new User();
		user1.setEmail("puppy@gmail.com");
		user1.setFirstName("Puppy");
		user1.setLastName("M");
		user1.setMobileNo("0123456789");
		user1.setPassword("testpassword");
		user1.setRole(roleDao.findById(2).get());
		userService.createUser(user1);

		/* Test VehicleSubcategoryDao, FuelTypeDao */
		AdminService adminService = context.getBean(AdminService.class);
		VehicleSubcategoryDao vehiclesubcategoryDao = context.getBean(VehicleSubcategoryDao.class);
		FuelTypeDao fueltypeDao = context.getBean(FuelTypeDao.class);

		Vehicle vehicle = new Vehicle("AMG", "IND 345", "Black", true,
				"https://www.mercedes-amg.com/en/world-of-amg/news/press-information/mercedes-amg-gt-black-series-record-lap.html",
				vehiclesubcategoryDao.findById(2).get(), locationDao.findById(1).get(), fueltypeDao.findById(1).get());
		adminService.registerVehicle(vehicle);

		/* Test BookingService AdminService LocationDao VehicleDao */
		BookingService bookingService = context.getBean(BookingService.class);
		Booking booking = new Booking();
		booking.setUser(user1);
		booking.setBookingDate(new Date());
		booking.setDropOffDate(new Date());
		booking.setLocation(locationDao.findById(1).get());
		booking.setAmount(200);
		booking.setPickupDate(new Date());
		booking.setVehicleWithBooking(vehicle);

		adminService.changeAvailabilityStatus(vehicle.getVehicleId(), false);

		bookingService.addBooking(booking);

		/* Test VehicleService and VehicleDao */
		VehicleService vehicleService = context.getBean(VehicleService.class);
		vehicleService.getAllVehicles().forEach(System.out::println);
	}

	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			initService.start();
		};
	}

}
