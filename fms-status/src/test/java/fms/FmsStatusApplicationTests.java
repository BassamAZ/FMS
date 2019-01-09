package fms;

import com.alten.fms.FmsStatusApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class FmsStatusApplicationTests {

	@Test
	public void contextLoads() {

		FmsStatusApplication.main(new String[]{""});

		Assert.assertEquals("done","done");

	}

}

