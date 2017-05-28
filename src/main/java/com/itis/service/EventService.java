package com.itis.service;

import com.itis.criteria.TimetableSearchCriteria;
import com.itis.model.Event;
import com.itis.model.enums.EventInterval;
import org.springframework.web.multipart.MultipartFile;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface EventService {

    Map<DayOfWeek, Map<EventInterval, List<Event>>> getTimetable(TimetableSearchCriteria criteria);

    void createTimetable(MultipartFile file);

    Event createEvent(Event event);
}
