package com.itis.service.impl;

import com.itis.model.Notification;
import com.itis.model.User;
import com.itis.repository.NotificationRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alt
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification getOne(Long id) {
        return notificationRepository.findOne(id);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(Notification notification) {
        notificationRepository.delete(notification);
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getCurrentUserSentNotifications() {
        return this.getSentNotificationsByUser(SecurityUtils.getCurrentUser());
    }

    @Override
    public List<Notification> getSentNotificationsByUser(User user) {
        return notificationRepository.findByUser(user);
    }
}
