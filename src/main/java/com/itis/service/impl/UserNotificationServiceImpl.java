package com.itis.service.impl;

import com.itis.model.Notification;
import com.itis.model.User;
import com.itis.model.UserGroup;
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
                SecurityUtils.getCurrentUser(), false);
    }

    @Override
    public void markUnreadNotificationsAsRead() {
        for (UserNotification unreadNotification: this.getCurrentUserUnreadUserNotifications()){
            unreadNotification.setIsRead(true);
            userNotificationRepository.save(unreadNotification);
        }
    }

    @Override
    public void createUserNotificationsByGroup(Notification notification, UserGroup userGroup) {
        for (User user : userGroup.getUsers()) {
            UserNotification userNotification = new UserNotification();
            userNotification.setNotification(notification);
            userNotification.setUser(user);
            userNotification.setIsRead(false);
            userNotificationRepository.save(userNotification);
        }
    }

    @Override
    public void createUserNotificationsByGroups(Notification notification, List<UserGroup> userGroups) {
        for (UserGroup userGroup : userGroups) {
            this.createUserNotificationsByGroup(notification, userGroup);
        }
    }
}
