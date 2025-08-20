package com.sds.customer_service.dto;


public class DeliveryRequestDTO {
	
	private String pickupLocation;
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
