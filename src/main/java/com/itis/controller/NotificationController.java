package com.itis.controller;

import com.itis.form.NotificationCreationForm;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.NotificationService;
import com.itis.service.UserGroupService;
import com.itis.service.UserNotificationService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author alt
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_NOTIFICATIONS_URL)
public class NotificationController {

    private final NotificationService notificationService;
    private final UserNotificationService userNotificationService;
    private final UserGroupService userGroupService;

    @Autowired
    public NotificationController(NotificationService notificationService,
                                  UserNotificationService userNotificationService,
                                  UserGroupService userGroupService) {
        this.notificationService = notificationService;
        this.userNotificationService = userNotificationService;
        this.userGroupService = userGroupService;
    }

    @GetMapping
    public String getNotificationsPage(ModelMap modelMap) {
        userNotificationService.markUnreadNotificationsAsRead();

        ArrayList<Role> redirectRoles = new ArrayList<>
                (Arrays.asList(Role.STAROSTA, Role.WORKER, Role.TEACHER));

        if (CollectionUtils.containsAny(SecurityUtils.getCurrentUser().getRoles(), redirectRoles)) {
            return "redirect:" + ApplicationUrls.WebAppUrls.BASE_NOTIFICATIONS_URL + "/extended";
        }
        modelMap.put("user_notifications", userNotificationService.getCurrentUserUserNotifications());
        modelMap.put("username", SecurityUtils.getCurrentUser().getFullName());

        return "notification/basic-notifications";
    }

    @GetMapping("/extended")
    public String getSentNotificationsPage(ModelMap modelMap) {
        modelMap.put("sent_notifications", notificationService.getCurrentUserSentNotifications());
        modelMap.put("received_notifications", userNotificationService.getCurrentUserUserNotifications());
        modelMap.put("notification_creation_form", new NotificationCreationForm());
        modelMap.put("groups_1", userGroupService.getUserGroupsByCourse(1));
        modelMap.put("groups_2", userGroupService.getUserGroupsByCourse(2));
        modelMap.put("groups_3", userGroupService.getUserGroupsByCourse(3));
        modelMap.put("groups_4", userGroupService.getUserGroupsByCourse(4));
        modelMap.put("groups_5", userGroupService.getUserGroupsByCourse(5));
        modelMap.put("groups_6", userGroupService.getUserGroupsByCourse(6));

        return "notification/extended-notifications";
    }

    @PostMapping("/add")
    public String sendNotification(@ModelAttribute(name = "notification_creation_form") @Valid
                                           NotificationCreationForm notificationCreationForm,
                                   BindingResult result, ModelMap modelMap) {

        if (result.hasErrors() || notificationService.sendNotification(notificationCreationForm) == null) {
            modelMap.put("sent_notifications", notificationService.getCurrentUserSentNotifications());
            modelMap.put("received_notifications", userNotificationService.getCurrentUserUserNotifications());
            modelMap.put("groups_1", userGroupService.getUserGroupsByCourse(1));
            modelMap.put("groups_2", userGroupService.getUserGroupsByCourse(2));
            modelMap.put("groups_3", userGroupService.getUserGroupsByCourse(3));
            modelMap.put("groups_4", userGroupService.getUserGroupsByCourse(4));
            modelMap.put("groups_5", userGroupService.getUserGroupsByCourse(5));
            modelMap.put("groups_6", userGroupService.getUserGroupsByCourse(6));

            return "notification/extended-notifications";
        }
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_NOTIFICATIONS_URL + "/extended";
    }
}
