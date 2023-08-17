package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootFallBackApplication {

	public static void main(String[] args) {
		System.out.println("In Spring boot");
		SpringApplication.run(SpringbootFallBackApplication.class, args);
	}

}
