package com.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by maratgatin on 13/05/2017.
 */

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "schedule/index";
    }
}
