package com.itis.controllers;

import com.itis.repositories.NotificationRepository;
import com.itis.repositories.UserRepository;
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
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/notifications")
    public String getNotifications(ModelMap modelMap) {
        //System.out.println(notificationRepository.findOne(1L).getUser());

        return "notifications";
    }
}
