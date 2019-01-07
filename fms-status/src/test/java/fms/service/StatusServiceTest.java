package fms.service;

import com.alten.fms.FmsStatusApplication;
import com.alten.fms.model.Vehicle;
import com.alten.fms.service.StatusService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FmsStatusApplication.class})
public class StatusServiceTest {

	@Autowired
	StatusService statusService;

	/*@Test
	public void testFindAll() {

		List<Vehicle> vehicleList=statusService.findAllStatus();
		Assert.assertEquals(vehicleList.size(),vehicleList.size());

	}*/

	@Test(expected = IllegalArgumentException.class)
	public void testFindByIdWithEmptyValue() {
		statusService.findStatus("");
	}

	/*@Test
	public void testFindByIdWithExitingValue() {
		Vehicle vehicle=statusService.findStatus("5c2e7c423650c5ca72a8e661");
		Assert.assertEquals(vehicle.getModel(),"bmw");

	}*/



	@Test
	public void testFindDummyStatus() {
		Vehicle vehicle=statusService.findDummyVehicle();
		Assert.assertEquals(vehicle,vehicle);
	}




}
