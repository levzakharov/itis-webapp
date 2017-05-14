package com.itis.controller;

import com.itis.form.NotificationCreationForm;
import com.itis.repository.UserGroupRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.NotificationService;
import com.itis.service.UserNotificationService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alt
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_NOTIFICATIONS_URL)
public class NotificationController {

    private final NotificationService notificationService;
    private final UserNotificationService userNotificationService;
    private final UserGroupRepository userGroupRepository;

    @Autowired
    public NotificationController(NotificationService notificationService,
                                  UserNotificationService userNotificationService,
                                  UserGroupRepository userGroupRepository) {
        this.notificationService = notificationService;
        this.userNotificationService = userNotificationService;
        this.userGroupRepository = userGroupRepository;
    }

    @GetMapping
    public String getNotificationsPage(ModelMap modelMap) {
        modelMap.put("user_notifications", userNotificationService.getCurrentUserUserNotifications());
        modelMap.put("username", SecurityUtils.getCurrentUser().getFullName());
        return "notification/notifications";
    }

    @GetMapping("/sent")
    public String getSentNotificationsPage(ModelMap modelMap) {
        modelMap.put("notifications", notificationService.getCurrentUserSentNotifications());
        modelMap.put("username", SecurityUtils.getCurrentUser().getFullName());
        modelMap.put("groups", userGroupRepository.findAll());
        return "notification/sent-notifications";
    }

    @GetMapping("/unread")
    public String getUnreadNotificationsPage(ModelMap modelMap) {
        modelMap.put("user_notifications", userNotificationService.getCurrentUserUnreadUserNotifications());
        modelMap.put("username", SecurityUtils.getCurrentUser().getFullName());
        return "notification/unread-notifications";
    }

    @PostMapping("/add")
    public String sendNotification(@ModelAttribute(name = "notification")
                                               NotificationCreationForm notificationCreationForm) {

        System.out.println(notificationCreationForm.getTheme());
        System.out.println(notificationCreationForm.getText());
        System.out.println(notificationCreationForm.getGroups());

        return "redirect:/sent";
    }
}
