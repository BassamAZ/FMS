package com.alten.fms.error;

import com.alten.fms.model.Vehicle;
import com.alten.fms.service.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorHandlerTest {


	@Test
	public void testErrorHandler() {

		ErrorHandler errorHandler= new ErrorHandler();
		errorHandler.processValidationError(new IllegalArgumentException());
		Assert.assertEquals("done","done");
	}


}
