package com.itis.controller;

import com.itis.service.EventService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_SCHEDULE_URL)
public class ScheduleController {

    private final EventService eventService;

    @Autowired
    public ScheduleController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public String getSchedulePage() {
        return "schedule/index";
    }

    @GetMapping("/search")
    public String getSchedule() {
        return "schedule/week_overall";
    }

    @GetMapping("/period/group/{userGroupId}")
    public String getUserGroupScheduleByPeriod(@PathVariable("userGroupId") Long userGroupId,
                                               @RequestParam Long startDate,
                                               @RequestParam Long endDate, Model model) {
        model.addAttribute("schedule",
                eventService.getScheduledBetweenByGroup(startDate, endDate, userGroupId));
        return "group_schedule";
    }

}