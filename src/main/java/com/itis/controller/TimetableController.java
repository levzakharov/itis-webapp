package com.itis.controller;

import com.itis.criteria.TimetableSearchCriteria;
import com.itis.model.Event;
import com.itis.model.UserGroup;
import com.itis.model.enums.EventInterval;
import com.itis.service.EventService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.itis.criteria.TimetableSearchCriteria.INTERVAL_WEEK;
import static com.itis.criteria.TimetableSearchCriteria.PERSONALITY_ALL;

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
    public String getSchedule(@ModelAttribute TimetableSearchCriteria criteria,
                              Model model) {
        if (PERSONALITY_ALL.equals(criteria.getPersonality())) {
            if (INTERVAL_WEEK.equals(criteria.getInterval())) {
                Map<DayOfWeek, Map<EventInterval, List<Event>>> timetable = eventService.getTimetable(criteria);
                model.addAttribute("timetable", timetable);
                List<UserGroup> userGroups = new ArrayList<>();
                timetable.forEach((dayOfWeek, eventIntervalListMap) -> eventIntervalListMap.forEach((eventInterval, events) ->
                        events.forEach(event -> {
                            if (!userGroups.contains(event.getUserGroup())) {
                                userGroups.add(event.getUserGroup());
                            }
                        })));
                model.addAttribute("userGroups", userGroups);

                return "timetable/week_overall";
            }

        }
        return null;

    }

    @PostMapping(ApplicationUrls.WebAppUrls.TIMETABLE_CSV)
    public String createTimetableWithCsvFile(MultipartFile file) {
        eventService.createTimetable(file);
        return "redirect:/" + ApplicationUrls.WebAppUrls.BASE_TIMETABLE_URL;
    }


}