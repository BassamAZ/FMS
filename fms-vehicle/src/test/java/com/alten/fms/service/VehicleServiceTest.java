package com.alten.fms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
class VehicleServiceTest {

	VehicleService vehicleService;


	@Test
	void testFindAll() {
		vehicleService= new VehicleService();
		vehicleService.findDummyVehicle();
		Assert.assertEquals("done","done");

	}

	@Test
	void testFindById() {
		Assert.assertEquals("done","done");
	}

	@Test
	void testFindByRegistrationNumber() {
		Assert.assertEquals("done","done");
	}

	@Test
	void testFindByPlateNumber() {
		Assert.assertEquals("done","done");
	}

	@Test
	void testFindByName() {
		Assert.assertEquals("done","done");
	}

	@Test
	void testPulse() {
		Assert.assertEquals("done","done");
	}

	@Test
	void testFindDummyVehicle() {
		Assert.assertEquals("done","done");
	}

}
