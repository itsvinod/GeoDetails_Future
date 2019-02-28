package com.geodetails.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
public class GeodetailsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeodetailsApplication.class, args);
	}
}
