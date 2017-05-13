package com.itis.controller;

import com.itis.utils.ApplicationUrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_NEWS_URL)
public class NewsController {

    @GetMapping
    public String index() {
        return "news/index";
    }

}
