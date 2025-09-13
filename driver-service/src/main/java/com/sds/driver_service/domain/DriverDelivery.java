package com.sds.driver_service.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DriverDelivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "driver_id",nullable = false)
	private Driver driver;
	@Column(nullable = false)
	private Long deliveryId;
	private Date acceptedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Date getAcceptedAt() {
		return acceptedAt;
	}
	public void setAcceptedAt(Date acceptedAt) {
		this.acceptedAt = acceptedAt;
	}
	
	
}
