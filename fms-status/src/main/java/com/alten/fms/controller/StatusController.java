package com.alten.fms.controller;

import com.alten.fms.model.Vehicle;
import com.alten.fms.service.StatusService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@EnableSwagger2
@RequestMapping("/fms")
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@GetMapping("/status")
	public List <Vehicle> getStatuses(){

		return statusService.findAllStatus();
	}

	@HystrixCommand(fallbackMethod = "getDummyStatus",   commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60") })
	@GetMapping("/status/{vehicleId}")
	public Vehicle getStatus(@PathVariable("vehicleId")String vehicleId){
		return statusService.findStatus(vehicleId);

	}


	public Vehicle getDummyStatus(String id){
		return statusService.findDummyVehicle();
	}


	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	public StatusService getStatusService() {
		return statusService;
	}
}

