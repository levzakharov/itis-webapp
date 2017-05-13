package com.itis.controller;

import com.itis.service.NotificationService;
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

    @Autowired
    NotificationService notificationService;

    @GetMapping
    public String getNotifications(ModelMap modelMap) {
        return "notifications";
    }
}
