package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.AdminService;
import com.upgrad.hirewheels.services.InitService;
import com.upgrad.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HireWheelsApplication{

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		RoleDao roleDao = context.getBean(RoleDao.class);
		LocationDao locationDao = context.getBean(LocationDao.class);

		/* Test UserService and RoleDao */
		User user1 = new User();
		user1.setEmail("abc@xyz");
		user1.setFirstName("Yatin");
		user1.setLastName("Tendulkar");
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

	}
	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			initService.start();
		};
	}

}
