package com.itis.controller;

import com.itis.security.SecurityUtils;
import com.itis.service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by r.khakov
 */
@ControllerAdvice("com.itis.controller")
public class GlobalController {
    private final UserNotificationService userNotificationService;

    @Autowired
    public GlobalController(UserNotificationService userNotificationService) {
        this.userNotificationService = userNotificationService;
    }

    @ModelAttribute
    public void getFullName(ModelMap model) {
        if (SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken) {
            model.addAttribute("username", SecurityUtils.getCurrentUser().getFullName());
            model.addAttribute("docuser", SecurityUtils.getCurrentUser());
        }
    }

    @ModelAttribute
    public void get(ModelMap model) {
        if (SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken) {
            model.addAttribute("unread_notifications_count",
                    userNotificationService.getCurrentUserUnreadUserNotifications().size());
        }
    }
}