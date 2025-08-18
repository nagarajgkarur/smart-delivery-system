package com.sds.delivery_service.model;

public class DeliveryDTO {
	
	private Boolean status;
	private Long driverId;
	private Long deliveryRequestId;
	private String pickuplocation;
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
