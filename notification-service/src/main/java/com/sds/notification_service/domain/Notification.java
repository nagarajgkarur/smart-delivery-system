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
	@Column(nullable = false)
	private Long deliveryId;
	private Long driverId;
	@Column(nullable = false)
	private String customerContact;
	@Column(nullable = false)
	private String 	message;
	private OffsetDateTime sentAt;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
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
	public String getCustomerContadct() {
		return customerContact;
	}
	public void setCustomerContadct(String customerContact) {
		this.customerContact = customerContact;
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
	@Override
	public String toString() {
		return "Notification [id=" + id + ", deliveryId=" + deliveryId + ", driverId=" + driverId
				+ ", customerContadct=" + customerContact + ", message=" + message + ", sentAt=" + sentAt + ", status="
				+ status + ", channel=" + channel + "]";
	}
	
}
