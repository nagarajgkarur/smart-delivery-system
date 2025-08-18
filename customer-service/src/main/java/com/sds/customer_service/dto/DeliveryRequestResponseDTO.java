package com.sds.customer_service.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryRequestResponseDTO {
	
	private Long Id;
	private Long customerId;
	private String pickupLocation;
	private String dropLocation;
	private LocalDateTime requestDate;
	private DeliveryResponseDTO deliveryResponseDTO;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public DeliveryResponseDTO getDeliveryResponseDTO() {
		return deliveryResponseDTO;
	}
	public void setDeliveryResponseDTO(DeliveryResponseDTO deliveryResponseDTO) {
		this.deliveryResponseDTO = deliveryResponseDTO;
	}

}
