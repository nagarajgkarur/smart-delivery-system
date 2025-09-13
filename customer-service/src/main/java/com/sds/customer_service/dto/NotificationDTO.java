package com.sds.customer_service.dto;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDTO {

	private Long deliveryId;
	private Long driverId;
	private String customerContadct;
	private String 	message;
	private OffsetDateTime sentAt;
	private String channel;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public Long getDriverId() {
		return driverId;
	}
	public String getCustomerContadct() {
		return customerContadct;
	}
	public String getMessage() {
		return message;
	}
	public OffsetDateTime getSentAt() {
		return sentAt;
	}
	public String getChannel() {
		return channel;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public void setCustomerContadct(String customerContadct) {
		this.customerContadct = customerContadct;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSentAt(OffsetDateTime sentAt) {
		this.sentAt = sentAt;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	
}
