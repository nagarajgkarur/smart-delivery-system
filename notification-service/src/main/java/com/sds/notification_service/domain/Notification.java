package com.sds.notification_service.domain;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long deliveryId;
	private Long driverId;
	private Number customerContadct;
	private String 	message;
	@Column(nullable = false)
	private OffsetDateTime sentAt;
	private String status;
	private String channel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public Number getCustomerContadct() {
		return customerContadct;
	}
	public void setCustomerContadct(Number customerContadct) {
		this.customerContadct = customerContadct;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public OffsetDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(OffsetDateTime sentAt) {
		this.sentAt = sentAt;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
}
