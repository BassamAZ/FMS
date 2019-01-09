package com.alten.fms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.turbine.stream.TurbineStreamAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FmsTurbineStreamServiceApplicationTests {

	@Test
	public void contextLoads() {

		FmsTurbineStreamServiceApplication.main(new String[]{""});
		Assert.assertEquals("done","done");

	}

}

