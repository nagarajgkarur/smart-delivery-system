package com.sds.notification_service.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationResponseDTO {

	private Long id;
	private Long deliveryId;
	private Long driverId;
	private String customerContact;
	private String 	message;
	private OffsetDateTime sentAt;
	private String channel;
	private String status;
	
	public Long getId() {
		return id;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public Long getDriverId() {
		return driverId;
	}
	public String getCustomerContadct() {
		return customerContact;
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
	public String getStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public void setCustomerContadct(String customerContact) {
		this.customerContact = customerContact;
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
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
