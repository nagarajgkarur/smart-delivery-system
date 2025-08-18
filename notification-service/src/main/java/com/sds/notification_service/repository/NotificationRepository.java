package com.sds.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sds.notification_service.domain.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
