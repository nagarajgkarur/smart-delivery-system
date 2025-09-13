package com.sds.driver_service.model;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DriverDTO {

	@NotBlank(message = "contactNumber is required")
	@Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10–15 digits")
	private String contactNumber;
	@NotBlank(message="name is required")
	@Size(max=255,message="name must be within 255 charecter")
	private String name;
	@NotBlank(message = "Vehicle number is required")
	@Size(max = 15, message = "Vehicle number must be within 15 characters")
	@Pattern(regexp = "^[A-Za-z0-9-]+$", message = "Vehicle number must be alphanumeric")
	private String vehicleNumber;
	private Date registeredAt;
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Date getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}
	
	
}
