package com.alten.fms.repo;

import com.alten.fms.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {


    public Vehicle findByRegistrationNumber(String registrationNumber);
    public List<Vehicle> findByName(String name);
    public Vehicle findByPlateNumber(String plateNumber);
}
