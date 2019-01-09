package com.alten.fms.controller;

import com.alten.fms.model.Status;
import com.alten.fms.model.Vehicle;
import com.alten.fms.service.StatusService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusControllerTest {

    @Test
    public void getStatuses() {

        StatusService mockStatusService=mock(StatusService.class);

        List<Vehicle> mockVehicleList= new ArrayList<Vehicle>(){{add(new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode())); }};

        Mockito.when(mockStatusService.findAllStatus()).thenReturn(mockVehicleList);

        StatusController statusController=new StatusController();
        statusController.setStatusService(mockStatusService);

        List<Vehicle> vehicleList=statusController.getStatuses();

        Assert.assertEquals(vehicleList.size(),1);

    }

    @Test
    public void getStatus() {

        StatusService mockStatusService=mock(StatusService.class);

        Vehicle mockVehicle=new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode());

        Mockito.when(mockStatusService.findStatus("123")).thenReturn(mockVehicle);

        StatusController statusController=new StatusController();
        statusController.setStatusService(mockStatusService);

        Vehicle vehicle=statusController.getStatus("123");

        Assert.assertEquals(vehicle.getModel(),"honda");
    }

    @Test
    public void getDummyStatus() {

        StatusService mockStatusService=mock(StatusService.class);

        Vehicle mockVehicle=new Vehicle("123","name","honda","123","123", Status.CONNECTED.getStatusCode());

        Mockito.when(mockStatusService.findDummyVehicle()).thenReturn(mockVehicle);

        StatusController statusController=new StatusController();
        statusController.setStatusService(mockStatusService);

        Vehicle vehicle=statusController.getDummyStatus("123");

        Assert.assertEquals(vehicle.getModel(),"honda");
    }
}