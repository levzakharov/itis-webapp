package com.itis.services.impl;

import com.itis.repositories.NotificationRepository;
import com.itis.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alt
 */
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;


}
