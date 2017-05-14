package com.itis.service;

import com.itis.model.Notification;
import com.itis.model.User;

import java.util.List;

/**
 * @author alt
 */
public interface NotificationService {
    Notification getOne(Long id);

    Notification update(Notification notification);

    void delete(Notification notification);

    Notification create(Notification notification);

    List<Notification> getCurrentUserSentNotifications();

    List<Notification> getSentNotificationsByUser(User user);
}
