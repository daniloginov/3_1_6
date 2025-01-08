package com.example.demo;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication implements CommandLineRunner {
	private UserService service;
	private static String finalCode;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println(finalCode);
	}

	@Override
	public void run(String... args) {
		service.getAllUsers();
		finalCode =
				service.addUser(
								new UserEntity(3L, "James", "Brown", (byte) 24))
						.getBody();
		finalCode +=
				service.updateUser(
								new UserEntity(3L, "Thomas", "Shelby", (byte) 25))
						.getBody();
		finalCode +=
				service.deleteUser(3L)
						.getBody();
	}
}