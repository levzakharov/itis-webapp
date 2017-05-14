package com.itis.service;

import com.itis.model.User;
import com.itis.model.UserNotification;

import java.util.List;

/**
 * Created by r.khakov
 */
public interface UserNotificationService {
    List<UserNotification> getUserNotificationByUser(User user);
    List<UserNotification> getCurrentUserUserNotification();
}
