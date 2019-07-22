package com.example.hajiboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HajibootApplication {

	@GetMapping("/")
	String home(@RequestParam(name = "firstname", required = false) String firstName,
				@RequestParam(name = "lastname", required = false) String lastName) {
		String response;
		String name;
		Boolean isFirstName = !(firstName == null);
		Boolean isLastName = !(lastName == null);

		if (!isFirstName && !isLastName) {
			response = "Hello, welcome to Spring Boot!";
			return response;
		}

		if (isFirstName && isLastName) {
			name = firstName + " " + lastName;
		} else if (isFirstName) {
			name = firstName;
		} else {
			name = lastName;
		}

		response = "Hello " + name + ", welcome to Spring Boot!";
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootApplication.class, args);
	}

}
