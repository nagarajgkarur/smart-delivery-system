package com.sds.notification_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.notification_service.domain.Notification;
import com.sds.notification_service.model.NotificationDTO;
import com.sds.notification_service.model.NotificationResponseDTO;
import com.sds.notification_service.service.NotificationService;

@RestController
@RequestMapping(path = "/api/v1/")
public class NotificationController {

	@Autowired
	NotificationService notificationService;
	
	@PostMapping("/notification")
	public NotificationResponseDTO sendNotification(@RequestBody NotificationDTO notificationDTO) {
		System.out.println("Creating Notification");
		NotificationResponseDTO notificationResponseDTO = notificationService.sendNotification(notificationDTO);
		System.out.println("Completed Notification");
		return  notificationResponseDTO;
	}
	
	
	@GetMapping("/notification/{id}")
	public NotificationResponseDTO getNotification(@PathVariable Long id) {
		
		NotificationResponseDTO notificationResponseDTO = notificationService.getNotification(id);
		
		return notificationResponseDTO;
	}
	
	@GetMapping("/notification")
	public List<NotificationResponseDTO> getAllTracking(){
		return notificationService.getallNotification();
	}
	
	@PostMapping("/notification/{id}")
	public Notification updateNotification(@PathVariable Long id,@RequestBody NotificationDTO notificationDTO) {
		return notificationService.updateNotification(id,notificationDTO);
	}
	
	@DeleteMapping("/notification/{id}")
	public void deleteNotification(@PathVariable Long id) {
		notificationService.deleteNotification(id);
	}
}
