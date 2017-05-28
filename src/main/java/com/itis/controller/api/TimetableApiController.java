package com.itis.controller.api;

import com.itis.criteria.TimetableSearchCriteria;
import com.itis.model.Event;
import com.itis.model.UserGroup;
import com.itis.model.enums.EventInterval;
import com.itis.service.EventService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

/**
 * @author aleksandrpliskin on 26.05.17.
 */
@RestController
public class TimetableApiController {

    private final EventService eventService;

    @Autowired
    public TimetableApiController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation(value = "get timetable")
    @GetMapping(ApplicationUrls.ApiUrls.BASE_TIMETABLE_URL)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "interval"),
            @ApiImplicitParam(name = "personality")
    })

    public Map<DayOfWeek, Map<EventInterval, List<Event>>> getSchedule(@ModelAttribute TimetableSearchCriteria criteria) {
        return eventService.getTimetable(criteria);
    }
}