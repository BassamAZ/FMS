package com.alten.fms.client;


import com.alten.fms.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(name="fms-vehicle" ,url="http://localhost:8080")
public interface VehicleClient {

    @GetMapping("/fms/vehicle")
    List<Vehicle> findAll();

    @PostMapping("/fms/vehicle/{id}")
    Optional<Vehicle> pulse(@PathVariable("id") String id);
}
