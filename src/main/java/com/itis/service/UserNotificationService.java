package com.itis.service;

import com.itis.model.Notification;
import com.itis.model.User;
import com.itis.model.UserGroup;
import com.itis.model.UserNotification;

import java.util.List;

/**
 * Created by r.khakov
 */
public interface UserNotificationService {
    List<UserNotification> getUserNotificationsByUser(User user);
    List<UserNotification> getCurrentUserUserNotifications();
    List<UserNotification> getCurrentUserUnreadUserNotifications();
    void markUnreadNotificationsAsRead();
    void createUserNotificationsByGroup(Notification notification, UserGroup userGroup);
    void createUserNotificationsByGroups(Notification notification, List<UserGroup> userGroups);
}
