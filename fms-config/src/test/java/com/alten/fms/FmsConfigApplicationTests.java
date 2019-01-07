package com.alten.fms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FmsConfigApplicationTests {

	@Test
	public void contextLoads() {
		FmsConfigApplication fmsConfigApplication= new FmsConfigApplication();
		Assert.assertEquals(fmsConfigApplication,fmsConfigApplication);

	}

}

