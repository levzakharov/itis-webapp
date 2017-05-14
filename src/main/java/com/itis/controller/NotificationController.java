package com.itis.controller;

import com.itis.model.User;
import com.itis.model.UserNotification;
import com.itis.security.SecurityUtils;
import com.itis.service.NotificationService;
import com.itis.service.UserNotificationService;
import com.itis.utils.ApplicationUrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alt
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_NOTIFICATIONS_URL)
public class NotificationController {

    private final NotificationService notificationService;
    private final UserNotificationService userNotificationService;

    @Autowired
    public NotificationController(NotificationService notificationService, UserNotificationService userNotificationService) {
        this.notificationService = notificationService;
        this.userNotificationService = userNotificationService;
    }


    @GetMapping
    public String getNotifications(ModelMap modelMap) {
        User user = SecurityUtils.getCurrentUser();
        modelMap.put("notifications", userNotificationService.getCurrentUserUserNotification());
        return "notification/notifications";
    }

    @GetMapping("/add")
    public String addNotification(ModelMap modelMap){
        return "notification/add-notification";
    }

}
