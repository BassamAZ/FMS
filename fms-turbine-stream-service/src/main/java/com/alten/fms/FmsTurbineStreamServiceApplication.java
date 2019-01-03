package com.alten.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
@EnableDiscoveryClient
public class FmsTurbineStreamServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsTurbineStreamServiceApplication.class, args);
	}

}

