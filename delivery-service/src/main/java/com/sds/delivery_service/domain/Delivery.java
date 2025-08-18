package com.sds.delivery_service.domain;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean status;
	@Column(nullable = true)
	private Long driverId;
	private Long deliveryRequestId;
	private String pickuplocation;
	private String droplocation;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getPickuplocation() {
		return pickuplocation;
	}
	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}
	public String getDroplocation() {
		return droplocation;
	}
	public void setDroplocation(String droplocation) {
		this.droplocation = droplocation;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getDeliveryRequestId() {
		return deliveryRequestId;
	}
	public void setDeliveryRequestId(Long deliveryRequestId) {
		this.deliveryRequestId = deliveryRequestId;
	}
	@Override
	public String toString() {
		return "Delivery [id=" + id + ", status=" + status + ", driverId=" + driverId + ", deliveryRequestId="
				+ deliveryRequestId + ", pickuplocation=" + pickuplocation + ", droplocation=" + droplocation
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	
}
