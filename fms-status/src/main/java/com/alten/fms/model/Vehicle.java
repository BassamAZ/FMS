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
	private LocalDateTime latUpdatedDate;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getLatUpdatedDate() {
		return latUpdatedDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLatUpdatedDate(LocalDateTime latUpdatedDate) {
		this.latUpdatedDate = latUpdatedDate;
	}
}
