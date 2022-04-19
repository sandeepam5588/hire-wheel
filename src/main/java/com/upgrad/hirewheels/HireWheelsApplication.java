package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.services.InitService;
import com.upgrad.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HireWheelsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
	}
	@Autowired
	InitService initService;

	@Autowired
	UserService userService;
	@Autowired
	RoleDao roleDao;

	@Override
	public void run(String... args) throws Exception {
		initService.start();
		checkUser();
	}
	public void checkUser(){
		User user = userService.createUser(new User("Deepika","M Reddy", "5588", "puppy@gmail.com","9686697496", 50000.00f,roleDao.findById(2).get()));
		System.out.println("user created");
		System.out.println(user);

		User retrievedUser = userService.getUser(user);
		System.out.println("Retrieved user");
		System.out.println(retrievedUser);
	}
	/*
		//other way to run the start() of InitService without implementing the CommandLineRunner
		@Bean
		CommandLineRunner init(InitService initService) {
			return args -> {
				initService.start();
			};
		}
	 */
}
