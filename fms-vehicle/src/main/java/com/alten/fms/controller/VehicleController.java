package com.alten.fms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.fms.model.Vehicle;

@RestController
public class VehicleController {
	
	
	@GetMapping("/vehicle")
	public List <Vehicle> getAllVehicles(){
		
		List <Vehicle> vehicleList= new ArrayList<Vehicle>();
		
		Vehicle vehicle= new Vehicle();
		
		vehicle.setName("BMW");
		vehicleList.add(vehicle);
		
		return vehicleList;
		
	}

}
