package com.itis.controller.api;

import com.itis.form.NotificationCreationForm;
import com.itis.model.Notification;
import com.itis.model.UserNotification;
import com.itis.service.NotificationService;
import com.itis.service.UserNotificationService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by r.khakov
 */
@RestController
@RequestMapping(ApplicationUrls.ApiUrls.BASE_NOTIFICATIONS_URL)
public class NotificationApiController {
    private final NotificationService notificationService;
    private final UserNotificationService userNotificationService;

    @Autowired
    public NotificationApiController(NotificationService notificationService, UserNotificationService userNotificationService) {
        this.notificationService = notificationService;
        this.userNotificationService = userNotificationService;
    }

    @ApiOperation("Get list of send notifications (for decanat workers and starosta)")
    @GetMapping("/send")
    public List<Notification> sendNotificationsApi() {
        return notificationService.getCurrentUserSentNotifications();
    }
    @ApiOperation("Get list of all notifications")
    @GetMapping()
    @ResponseBody
    public List<UserNotification> comeUserNotificationsApi() {
        return userNotificationService.getCurrentUserUserNotifications();
    }
    @ApiOperation("Get list of unread notifications")
    @GetMapping("/unread")
    public List<UserNotification> readUserNotificationsApi() {
        return userNotificationService.getCurrentUserUnreadUserNotifications();
    }
    @ApiOperation("Add new notification. This method have validate for user notification")
    @PostMapping("add/new/notification")
    public Notification createNotification(
            @RequestBody NotificationCreationForm notificationCreationForm){
        return notificationService.sendNotification(notificationCreationForm);
    }
}
