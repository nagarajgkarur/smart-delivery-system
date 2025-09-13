package com.sds.driver_service.model;

import jakarta.validation.constraints.NotNull;

public class DriverDeliveryDTO {

	@NotNull(message = "driverId is required")
	private Long driverId;
	@NotNull(message="deliveryId is required")
	private Long deliveryId;
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
}
