package com.sds.notification_service.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sds.notification_service.domain.Notification;
import com.sds.notification_service.model.NotificationDTO;
import com.sds.notification_service.model.NotificationResponseDTO;

import ch.qos.logback.core.util.StringUtil;


@Component
public class NotificationUtility {

	public Notification getNotificationInstance(NotificationDTO notificationDTO) {
		Notification notification = new Notification();
		if(notificationDTO.getDeliveryId()!=null) {
			notification.setDeliveryId(notificationDTO.getDeliveryId());
		}
		if(notificationDTO.getDriverId()!=null) {
			notification.setDriverId(notificationDTO.getDriverId());
		}
		if(!StringUtil.isNullOrEmpty(notificationDTO.getChannel())) {
			notification.setChannel(notificationDTO.getChannel());
		}
		if(notificationDTO.getCustomerContadct() !=null) {
			notification.setCustomerContadct(notificationDTO.getCustomerContadct());
		}
		if(!StringUtil.isNullOrEmpty(notificationDTO.getMessage())) {
			notification.setMessage(notificationDTO.getMessage());
		}
		return notification;
	}
	
	public NotificationResponseDTO getNotificationResponseInstance(Notification notification) {
		NotificationResponseDTO notificationResponseDTO = new NotificationResponseDTO();
		notificationResponseDTO.setId(notification.getId());
		notificationResponseDTO.setDeliveryId(notification.getDeliveryId());
		notificationResponseDTO.setDriverId(notification.getDriverId());
		notificationResponseDTO.setCustomerContadct(notification.getCustomerContadct());
		notificationResponseDTO.setChannel(notification.getChannel());
		notificationResponseDTO.setMessage(notification.getMessage());
		notificationResponseDTO.setSentAt(notification.getSentAt());
		notificationResponseDTO.setStatus(notification.isStatus());
		return notificationResponseDTO;
	}
	
	public List<NotificationResponseDTO> getAllNotificationResponseInstance(List<Notification> notification){
		return notification.stream().map(e->getNotificationResponseInstance(e)).collect(Collectors.toList());
	}
}

