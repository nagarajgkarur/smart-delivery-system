package com.sds.customer_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DeliveryRequestDTO {
	
	@NotBlank(message = "Pickup location is required")
	@Size(max = 255, message = "Pickup location must not exceed 255 characters")
	private String pickupLocation;
	
	@NotBlank(message="Drop location is required")
	@Size(max = 255, message = "Drop location must not exceed 255 characters")
	private String dropLocation;
	
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

	
	
}
