package com.alten.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard

public class FmsMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsMonitoringApplication.class, args);
	}

}

