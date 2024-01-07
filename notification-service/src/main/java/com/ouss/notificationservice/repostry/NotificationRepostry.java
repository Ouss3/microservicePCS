package com.ouss.notificationservice.repostry;

import com.ouss.notificationservice.entites.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepostry extends JpaRepository<Notification, Integer> {
}
