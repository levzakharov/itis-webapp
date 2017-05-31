package com.itis.controller;

import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.utils.ApplicationUrls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maratgatin on 28/05/2017.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_CHAT_URL)
public class ChatController {
    @GetMapping
    public String getChatPage(ModelMap model){
        if (SecurityUtils.getCurrentUser().getRoles().contains(Role.WORKER)) {
            model.addAttribute("my_chat_name", "dean");
            return "chat/chat_decanat";
        }
        else {
            model.addAttribute("my_chat_name", SecurityUtils.getCurrentUser().getEmail());
            return "chat/chat";
        }
    }
}
