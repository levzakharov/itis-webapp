package com.itis.controller;

import com.itis.utils.ApplicationUrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_NEWS_URL)
public class NewsController {
    public String index() {
        return "news/index";
    }
}
