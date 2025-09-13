package com.sds.notification_service.model;

import java.time.OffsetDateTime;


import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDTO {

	@NotNull(message = "deliveryId is required")
	private Long deliveryId;
	private Long driverId;
	@NotBlank(message = "customerContact is required")
	@Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be numeric and between 10 to 15 digits")
	private String customerContact;
	@NotBlank(message = "message is required")
	private String 	message;
	private OffsetDateTime sentAt;
	@NotBlank(message = "status is required")
	private String status;
	@NotBlank(message="channel is required")
	private String channel;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
