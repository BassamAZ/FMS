package com.alten.fms.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Vehicle {
	
	@Id
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
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getLatUpdatedDate() {
		return latUpdatedDate;
	}
	public void setLatUpdatedDate(LocalDateTime latUpdatedDate) {
		this.latUpdatedDate = latUpdatedDate;
	}
	
	


}
