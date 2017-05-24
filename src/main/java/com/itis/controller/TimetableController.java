package com.itis.controller;

import com.itis.service.EventService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Controller
public class TimetableController {

    private final EventService eventService;

    @Autowired
    public TimetableController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(ApplicationUrls.WebAppUrls.BASE_TIMETABLE_URL)
    public String getSchedulePage() {
        return "timetable/index";
    }

    @GetMapping(ApplicationUrls.WebAppUrls.TIMETABLE_SEARCH)
    public String getSchedule(@RequestParam String interval,
                              @RequestParam String personality,
                              Model model) {
        model.addAttribute("timetable", eventService.getTimetable(interval, personality));
        return "timetable/panel";
    }

    @PostMapping(ApplicationUrls.WebAppUrls.TIMETABLE_CSV)
    public String createTimetableWithCsvFile(MultipartFile file) {
        eventService.createTimetable(file);
        return "redirect:/" + ApplicationUrls.WebAppUrls.BASE_TIMETABLE_URL;
    }


}