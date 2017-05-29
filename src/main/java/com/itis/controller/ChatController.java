package com.itis.controller;

import com.itis.utils.ApplicationUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maratgatin on 28/05/2017.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_CHAT_URL)
public class ChatController {
    @GetMapping
    public String getChatPage(){
        return "chat/chat"; //chat_decanat.ftl для деканата
    }
}
