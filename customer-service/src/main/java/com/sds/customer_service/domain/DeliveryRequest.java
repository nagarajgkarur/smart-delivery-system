package com.sds.customer_service.domain;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DeliveryRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id",nullable = false)
	private Customer customer;
	
	@Column(nullable = false,length = 255)
	private String pickupLocation;
	@Column(nullable = false,length = 255)
	private String dropLocation;
	private LocalDateTime requestDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public LocalDateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}
	
	
	
}
