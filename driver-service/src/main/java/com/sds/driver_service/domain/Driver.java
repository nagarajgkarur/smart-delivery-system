package com.sds.driver_service.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String contactNumber;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String vehicleNumber;
	private Date registeredAt;
	
	@OneToMany(mappedBy = "driver",cascade = CascadeType.ALL,orphanRemoval = true)
	List<DriverDelivery> driverDeliveries;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
