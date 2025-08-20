package com.sds.customer_service.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverResponseDTO {
	
	private Long id;
	private Number contactNumber;
	private String name;
	private String vehicleNumber;
	private Date registeredAt;
	public Long getId() {
		return id;
	}
	public Number getContactNumber() {
		return contactNumber;
	}
	public String getName() {
		return name;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public Date getRegisteredAt() {
		return registeredAt;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setContactNumber(Number contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}
	
	
	
	

}
