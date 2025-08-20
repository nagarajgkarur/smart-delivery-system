package com.sds.notification_service.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.notification_service.domain.Notification;
import com.sds.notification_service.model.NotificationDTO;
import com.sds.notification_service.model.NotificationResponseDTO;
import com.sds.notification_service.repository.NotificationRepository;
import com.sds.notification_service.utility.NotificationUtility;

@Service
public class NotificationService {
	
	@Autowired
	NotificationUtility notificationUtility;
	
	@Autowired
	NotificationRepository notificationRepository;

	public NotificationResponseDTO sendNotification(NotificationDTO notificationDTO) {
		Notification notification = notificationUtility.getNotificationInstance(notificationDTO);
		boolean success = new Random().nextBoolean(); // true or false
		if (success) {
		    notification.setStatus("SUCCESS");
		    notification.setSentAt(OffsetDateTime.now());
		} else {
		    notification.setStatus("FAILED");
		    notification.setSentAt(OffsetDateTime.now());
		}
		notification = notificationRepository.save(notification);
		return notificationUtility.getNotificationResponseInstance(notification);
	}

	public NotificationResponseDTO getNotification(Long id) {
		return notificationUtility.getNotificationResponseInstance(notificationRepository.findById(id).get());
	}

	public List<NotificationResponseDTO> getallNotification() {
		return notificationUtility.getAllNotificationResponseInstance(notificationRepository.findAll());
	}

	public Notification updateNotification(Long id, NotificationDTO notificationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteNotification(Long id) {
		notificationRepository.deleteById(id);
	}

}
