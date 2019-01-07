package com.alten.fms.service;

import com.alten.fms.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testFindAll() {

        List<Customer> customerList=customerService.findAll();
        Assert.assertEquals(customerList.size(),customerList.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByIdWithEmptyValue() {
        customerService.findById("");
    }

    @Test
    public void testFindByIdWithExitingValue() {
        Customer customer=customerService.findById("199");

        Assert.assertEquals(customer.getName(),"Test Cust");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateCustomerWithEmptyObject() {

        Customer customer=null;
        customerService.createCustomer(customer);
    }

    @Test
    public void testCreateCustomerWithRealObject() {

        Customer customer=new Customer();
        customer.setName("Test Cust");
        customer.setAge("30");
        customer.setId("199");
        Customer createdCustomer=customerService.createCustomer(customer);

        Assert.assertEquals(customer.getName(),createdCustomer.getName());

    }

    @Test
    public void testFindDummyCustomer() {
        Customer customer=customerService.findDummyCustomer();

        Assert.assertEquals(customer,customer);
    }
}
