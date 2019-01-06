package com.alten.fms.controller;

import com.alten.fms.model.Vehicle;
import com.alten.fms.service.VehicleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@EnableSwagger2
@RequestMapping("/fms")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/vehicle")
	public List <Vehicle> getAllVehicles(){
		
		return vehicleService.findAll();
		
	}

	@HystrixCommand(fallbackMethod = "getDummyVehicle",   commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60") })
	@GetMapping("/vehicle/{id}")
	public Vehicle getVehicle(@PathVariable("id")String id){
		return vehicleService.findById(id);

	}


	public Vehicle getDummyVehicle(String id){
		return vehicleService.findDummyVehicle();
	}


	@PostMapping("/vehicle/{id}")
	public Vehicle pulse(@PathVariable("id") String id){
		return vehicleService.pulse(id).orElse(null);

	}



}
