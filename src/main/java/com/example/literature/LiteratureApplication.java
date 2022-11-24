package com.example.literature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteratureApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteratureApplication.class, args);
		System.out.println("Server has started...");
		System.out.println("Visit http://localhost:8080/h2-ui");
	}

}
