package com.upgrad.hirewheels;

import com.upgrad.hirewheels.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HireWheelsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
	}
	@Autowired
	InitService initService;

	@Override
	public void run(String... args) throws Exception {
		initService.start();
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
