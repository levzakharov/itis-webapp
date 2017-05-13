package com.itis.controller;

import com.itis.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author alt
 */
@Controller
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/notifications")
    public String getNotifications(ModelMap modelMap) {
        return "notifications";
    }
}
