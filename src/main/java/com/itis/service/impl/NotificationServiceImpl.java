package com.itis.service.impl;

import com.itis.model.Notification;
import com.itis.repository.NotificationRepository;
import com.itis.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alt
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public Notification getOne(Long id) {
        return notificationRepository.findOne(id);
    }
}
