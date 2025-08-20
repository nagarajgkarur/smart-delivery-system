package com.sds.delivery_service.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponseDTO {
	
	private Long id;
	private boolean status;
	private Long driverId;
	private Long deliveryRequestId;
	private String pickuplocation;
	private String droplocation;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
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
	@Override
	public String toString() {
		return "DeliveryResponseDTO [id=" + id + ", status=" + status + ", driverId=" + driverId
				+ ", deliveryRequestId=" + deliveryRequestId + ", pickuplocation=" + pickuplocation + ", droplocation="
				+ droplocation + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
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
	
	

}
