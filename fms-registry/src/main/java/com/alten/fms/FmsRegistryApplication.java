package com.alten.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FmsRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsRegistryApplication.class, args);
	}

}

