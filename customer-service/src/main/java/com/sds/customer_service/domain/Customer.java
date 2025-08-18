package com.sds.customer_service.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String name;
	private Number contactNumber;
	private String email;
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DeliveryRequest> deliveryRequests;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Number getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Number contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<DeliveryRequest> getDeliveryRequests() {
		return deliveryRequests;
	}
	public void setDeliveryRequests(List<DeliveryRequest> deliveryRequests) {
		this.deliveryRequests = deliveryRequests;
	}

	
	
}
