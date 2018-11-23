package com.dev.engineering;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestBApplication	 {
	
	public static void main(String[] args) {
		SpringApplication.run(RestBApplication.class, args);
		System.setProperty("spring.config.name", "api.properties");
	}
}
