package com.alten.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FmsVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsVehicleApplication.class, args);
	}

}

