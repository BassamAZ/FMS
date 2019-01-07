package com.alten.fms.service;

import com.alten.fms.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {

	@Autowired
	VehicleService vehicleService;

	@Test
	public void testFindAll() {

		List<Vehicle> customerList=vehicleService.findAll();
		Assert.assertEquals(customerList.size(),customerList.size());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByIdWithEmptyValue() {
		vehicleService.findById("");
	}

	@Test
	public void testFindByIdWithExitingValue() {
		Vehicle vehicle=vehicleService.findById("5c2e7c423650c5ca72a8e661");

		Assert.assertEquals(vehicle.getModel(),"bmw");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByNameWithEmptyValue() {
		vehicleService.findByName("");
	}

	@Test
	public void testFindByNameWithExitingValue() {
		List<Vehicle> vehicle=vehicleService.findByName("cartest");

		Assert.assertEquals(vehicle.size(),vehicle.size());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByPlateNumberWithEmptyValue() {
		vehicleService.findByPlateNumber("");
	}

	@Test
	public void testFindByPlateNumberWithExistingValue() {
		Vehicle vehicle=vehicleService.findByPlateNumber("1234");

		Assert.assertEquals(vehicle.getModel(),"bmw");

	}

	@org.junit.Test(expected = IllegalArgumentException.class)
	public void testFindByRegistrationNumberWithEmptyValue() {
		vehicleService.findByRegistrationNumber("");
	}

	@Test
	public void testFindByRegistrationNumberWithExistingValue() {
		Vehicle vehicle=vehicleService.findByRegistrationNumber("4321");

		Assert.assertEquals(vehicle.getModel(),"bmw");

	}


	@Test
	public void testFindDummyCustomer() {
		Vehicle vehicle=vehicleService.findDummyVehicle();

		Assert.assertEquals(vehicleService,vehicleService);
	}




}
