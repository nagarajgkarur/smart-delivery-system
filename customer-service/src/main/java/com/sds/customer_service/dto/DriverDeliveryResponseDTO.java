package com.sds.customer_service.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDeliveryResponseDTO {
	private Long id;
	private DriverResponseDTO driverResponseDTO;
	private Long deliveryId;
	private Date acceptedAt;
	public Long getId() {
		return id;
	}
	public DriverResponseDTO getDriverResponseDTO() {
		return driverResponseDTO;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public Date getAcceptedAt() {
		return acceptedAt;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDriverResponseDTO(DriverResponseDTO driverResponseDTO) {
		this.driverResponseDTO = driverResponseDTO;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public void setAcceptedAt(Date acceptedAt) {
		this.acceptedAt = acceptedAt;
	}
	
	
}
