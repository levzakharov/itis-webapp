package com.itis.service.impl;

import com.itis.model.User;
import com.itis.model.UserNotification;
import com.itis.repository.UserNotificationRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by r.khakov
 */
@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    private final UserNotificationRepository userNotificationRepository;

    @Autowired
    public UserNotificationServiceImpl(UserNotificationRepository userNotificationRepository) {
        this.userNotificationRepository = userNotificationRepository;
    }

    @Override
    public List<UserNotification> getUserNotificationsByUser(User user) {
        return userNotificationRepository.findByUser(user);
    }

    @Override
    public List<UserNotification> getCurrentUserUserNotifications() {
        return this.getUserNotificationsByUser(SecurityUtils.getCurrentUser());
    }

    @Override
    public List<UserNotification> getCurrentUserUnreadUserNotifications() {
        return userNotificationRepository.findByUserAndIsRead(
                SecurityUtils.getCurrentUser(), true);
    }

    @Override
    public void markUnreadNotificationsAsRead() {
        for (UserNotification unreadNotification: this.getCurrentUserUnreadUserNotifications()){
            unreadNotification.setRead(true);
            userNotificationRepository.save(unreadNotification);
        }

    }

}
