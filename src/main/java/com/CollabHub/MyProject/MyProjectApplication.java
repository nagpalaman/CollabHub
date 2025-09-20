package com.CollabHub.MyProject;

import com.CollabHub.MyProject.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner test(UserService userService) {
		return args -> {
			System.out.println("Total users: " + userService.getAllUsers().size());
			System.out.println("Services are working! 🎉");
		};
	}
}
