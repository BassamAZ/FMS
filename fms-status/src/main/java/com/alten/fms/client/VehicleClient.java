package com.alten.fms.client;


import com.alten.fms.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("fms-vehicle")
public interface VehicleClient {

    @GetMapping("/fms/vehicle")
    List<Vehicle> findAll();

    @GetMapping("/fms/vehicle/{id}")
    Vehicle getVehicle(@PathVariable("id")String id);


}
