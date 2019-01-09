package com.alten.fms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Customer")
public class Customer {

    @Id
    private String id;
    private String name;
    private String age;
    private List<String> vehicleIds;


    public Customer(String id, String name, String age, List<String> vehicleIds){

        this.id=id;
        this.name=name;
        this.age=age;
        this.vehicleIds=vehicleIds;

    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public List<String> getVehicleIds() {
        return vehicleIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setVehicleIds(List<String> vehicleIds) {
        this.vehicleIds = vehicleIds;
    }
}
