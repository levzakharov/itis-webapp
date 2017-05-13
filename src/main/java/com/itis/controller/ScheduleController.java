package com.itis.controller;

import com.itis.utils.ApplicationUrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_SCHEDULE_URL)
public class ScheduleController {

    @GetMapping
    public String getSchedulePage() {
        return "schedule/index";
    }

}
