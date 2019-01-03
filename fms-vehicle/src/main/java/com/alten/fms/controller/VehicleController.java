package com.alten.fms.controller;

import java.util.ArrayList;
import java.util.List;

import com.alten.fms.model.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.fms.model.Vehicle;

@RestController
@RequestMapping("/fms")
public class VehicleController {
	
	
	@GetMapping("/vehicle")
	public List <Vehicle> getAllVehicles(){
		
		List <Vehicle> vehicleList= new ArrayList<Vehicle>();
		
		Vehicle vehicle= new Vehicle();
		
		vehicle.setName("BMW");
		vehicle.setStatus(Status.CONNECTED.getStatusCode());
		vehicleList.add(vehicle);
		
		return vehicleList;
		
	}

}
