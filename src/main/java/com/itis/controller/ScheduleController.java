package com.itis.controller;

import com.itis.service.EventService;
import com.itis.utils.ApplicationUrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_SCHEDULE_URL)
public class ScheduleController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public String getSchedulePage() {
        return "schedule/index";
    }

    @PostMapping("/period")
    public String getScheduleByPeriod(@RequestParam Long startDate,
                                      @RequestParam Long endDate, Model model) {
        model.addAttribute("schedule", eventService.getScheduleBetween(startDate, endDate));
        return "schedule";
    }

    @PostMapping("/period/group/${groupId}")
    public String getUserGroupScheduleByPeriod(@PathVariable("groupId") String groupId,
                                               @RequestParam Long startDate,
                                               @RequestParam Long endDate, Model model) {
        model.addAttribute("schedule", eventService.getScheduleBetween(startDate, endDate));
        return "group_schedule";
    }

}
