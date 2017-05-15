package com.itis.controller.api;

import com.itis.model.Notification;
import com.itis.model.UserNotification;
import com.itis.service.NotificationService;
import com.itis.service.UserNotificationService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by r.khakov
 */
@Controller
@RequestMapping(ApplicationUrls.ApiUrls.BASE_NOTIFICATIONS_URL)
public class NotificationApiController {
    private final NotificationService notificationService;
    private final UserNotificationService userNotificationService;

    @Autowired
    public NotificationApiController(NotificationService notificationService, UserNotificationService userNotificationService) {
        this.notificationService = notificationService;
        this.userNotificationService = userNotificationService;
    }

    @ApiOperation("List of send notifications")
    @GetMapping("/send")
    @ResponseBody
    public List<Notification> sendNotificationsApi() {
        return notificationService.getCurrentUserSentNotifications();
    }
    @ApiOperation("List of all notifications")
    @GetMapping()
    @ResponseBody
    public List<UserNotification> comeUserNotificationsApi() {
        return userNotificationService.getCurrentUserUserNotifications();
    }
    @ApiOperation("List of unread notifications")
    @GetMapping("/unread")
    @ResponseBody
    public List<UserNotification> readUserNotificationsApi() {
        return userNotificationService.getCurrentUserUnreadUserNotifications();
    }
}
