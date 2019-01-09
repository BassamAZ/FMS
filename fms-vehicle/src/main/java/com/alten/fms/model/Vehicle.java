package com.alten.fms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Vehicle")
public class Vehicle {
	
	@Id
	private String id;
	
	private String name;
	private String model;
	private String plateNumber;
	private String registrationNumber;
	private String status;
	private LocalDateTime lastUpdatedDate;


	public Vehicle(String id,String name, String model, String plateNumber, String registrationNumber, String status){
		this.id=id;
		this.model=model;
		this.plateNumber=plateNumber;
		this.registrationNumber=registrationNumber;
		this.status=status;

	}

}
