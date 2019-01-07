package com.alten.fms.service;

import com.alten.fms.client.VehicleClient;
import com.alten.fms.model.Status;
import com.alten.fms.model.Vehicle;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatusService {

    @Autowired
    private VehicleClient vehicleClient;

    public Vehicle findDummyVehicle(){

       Vehicle vehicle= new Vehicle();
       vehicle.setName("Dummy Name");
       vehicle.setModel("Dummy Model");
       vehicle.setStatus(Status.CONNECTED.getStatusCode());

        return vehicle;
    }


    public Vehicle findStatus(String vehicleId){

        if (StringUtils.isEmpty(vehicleId)){
            throw new IllegalArgumentException("There is a missing: vehicleId");
        }

        return vehicleClient.getVehicle(vehicleId);
    }

    public List<Vehicle> findAllStatus(){

        return vehicleClient.findAll();
    }




	
	
	

}
