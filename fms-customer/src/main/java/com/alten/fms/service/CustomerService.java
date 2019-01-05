package com.alten.fms.service;

import com.alten.fms.model.Customer;
import com.alten.fms.repo.CustomerRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List <Customer> findAll(){
        return customerRepository.findAll();
    }


    public Customer findById( String  id){

        if (StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("There is a missing: id");
        }

        return customerRepository.findById(id).orElse(null);
    }


    public Customer createCustomer( Customer  customer){

        if (customer==null){
            throw new IllegalArgumentException("There is a object: customer");
        }

        return customerRepository.save(customer);
    }

    public Customer findDummyCustomer(){

        Customer customer= new Customer();
        customer.setName("Dummy Name");

        List <String> vehicleIds= new ArrayList<String>();

        vehicleIds.add("22");
        vehicleIds.add("33");
        vehicleIds.add("44");
        vehicleIds.add("55");
        vehicleIds.add("66");

        customer.setVehicleIds(vehicleIds);

        return customer;
    }




	
	
	

}
