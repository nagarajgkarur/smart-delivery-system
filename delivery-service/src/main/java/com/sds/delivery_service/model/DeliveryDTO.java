package com.sds.delivery_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DeliveryDTO {
	
	@NotNull(message="status is required")
	private Boolean status;
	private Long driverId;
	@NotNull(message="deliveryRequestId is required")
	private Long deliveryRequestId;
	@NotBlank(message="pickuplocation is required")
	@Size(max=255, message = "pickuplocation max length is 255 charecter")
	private String pickuplocation;
	@NotBlank(message="droplocation is required")
	@Size(max=255, message="droplocation max length is 255 charecter")
	private String droplocation;
	
	public Boolean isStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
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
	public Long getDeliveryRequestId() {
		return deliveryRequestId;
	}
	public void setDeliveryRequestId(Long deliveryRequestId) {
		this.deliveryRequestId = deliveryRequestId;
	}
	@Override
	public String toString() {
		return "DeliveryDTO [status=" + status + ", driverId=" + driverId + ", deliveryRequestId=" + deliveryRequestId
				+ ", pickuplocation=" + pickuplocation + ", droplocation=" + droplocation + "]";
	}

	
	
}
