package com.alten.fms.controller;


import com.alten.fms.model.Customer;
import com.alten.fms.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@EnableSwagger2
@RequestMapping("/fms")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List <Customer> getAllCustomers(){
		return customerService.findAll();
	}

	@HystrixCommand(fallbackMethod = "getDummyCustomer",   commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60") })
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id")String id){
		return customerService.findById(id);

	}

	@PostMapping("/customer")
	public Customer registerCustomer(@RequestBody Customer customer){
		return customerService.createCustomer(customer);

	}


	public Customer getDummyCustomer(String id){
		return customerService.findDummyCustomer();
	}



}
