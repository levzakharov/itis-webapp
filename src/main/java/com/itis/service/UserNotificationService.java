package com.itis.service;

import com.itis.model.User;
import com.itis.model.UserNotification;

import java.util.List;

/**
 * Created by r.khakov
 */
public interface UserNotificationService {
    List<UserNotification> getUserNotificationsByUser(User user);
    List<UserNotification> getCurrentUserUserNotifications();
    List<UserNotification> getCurrentUserUnreadUserNotifications();
}
