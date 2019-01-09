package com.alten.fms.controller;

import com.alten.fms.model.Status;
import com.alten.fms.model.Vehicle;
import com.alten.fms.service.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleControllerTest {

    @Test
    public void getAllVehicles() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        List<Vehicle> mockVehicleList= new ArrayList<Vehicle>(){{add(new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode())); }};

        Mockito.when(mockVehicleService.findAll()).thenReturn(mockVehicleList);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        List<Vehicle> vehicleList=vehicleController.getAllVehicles();

        Assert.assertEquals(vehicleList.size(),1);

    }

    @Test
    public void getVehicle() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        Vehicle mockVehicle= new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode());

        Mockito.when(mockVehicleService.findById("123")).thenReturn(mockVehicle);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        Vehicle vehicle=vehicleController.getVehicle("123");

        Assert.assertEquals(vehicle.getModel(),"honda");
    }

    @Test
    public void getDummyVehicle() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        Vehicle mockVehicle= new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode());

        Mockito.when(mockVehicleService.findDummyVehicle()).thenReturn(mockVehicle);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        Vehicle vehicle=vehicleController.getDummyVehicle("123");

        Assert.assertEquals(vehicle.getModel(),"honda");
    }

    @Test
    public void pulse() {

        VehicleService mockVehicleService=mock(VehicleService.class);

        Optional<Vehicle> mockVehicle= Optional.of(new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode()));

        Mockito.when(mockVehicleService.pulse("123")).thenReturn(mockVehicle);

        VehicleController vehicleController=new VehicleController();
        vehicleController.setVehicleService(mockVehicleService);

        Vehicle vehicle=vehicleController.pulse("123");

        Assert.assertEquals(vehicle.getModel(),"honda");
    }
}