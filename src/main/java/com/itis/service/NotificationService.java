package com.itis.service;

import com.itis.model.Notification;

/**
 * @author alt
 */
public interface NotificationService {
    Notification getOne(Long id);

    Notification update(Notification notification);

    void delete(Notification notification);

    Notification create(Notification notification);
}
