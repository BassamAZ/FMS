package com.alten.fms.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	
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
