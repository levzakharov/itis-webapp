package com.itis.service.impl;

import com.itis.criteria.TimetableSearchCriteria;
import com.itis.exceptions.TimetableCreationException;
import com.itis.model.Event;
import com.itis.model.UserGroup;
import com.itis.repository.EventRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.EventService;
import com.itis.utils.CSVParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.itis.criteria.TimetableSearchCriteria.INTERVAL_WEEK;
import static com.itis.criteria.TimetableSearchCriteria.PERSONALITY_ALL;
import static java.util.Objects.isNull;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Service
public class EventServiceImpl implements EventService {

    private static final Logger LOGGER = Logger.getLogger(EventServiceImpl.class);

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Map<UserGroup, List<Event>> getTimetable(TimetableSearchCriteria criteria) {
        if (PERSONALITY_ALL.equals(criteria.getPersonality())) {
            if (INTERVAL_WEEK.equals(criteria.getInterval())) {
                return getEvents();
            }
            return getEventsByDay(criteria.getInterval());
        }
        if (INTERVAL_WEEK.equals(criteria.getInterval())) {
            return getEventsByUserGroup();
        }
        return getEventsByUserGroupAndDay(criteria.getInterval());
    }

    @Override
    public void createTimetable(MultipartFile file) {
        try {
            CSVParser.parse(file.getBytes(), Event.class);
        } catch (IOException e) {
            LOGGER.error("error occured while parsing csv file to timetable events : ", e);
            throw new TimetableCreationException();
        }
    }

    private Map<UserGroup, List<Event>> getEventsByUserGroup() {
        List<Event> events = eventRepository
                .findByUserGroup(SecurityUtils.getCurrentUser().getUserGroup());
        return generateTimetable(events);
    }

    private Map<UserGroup, List<Event>> getEventsByUserGroupAndDay(String interval) {
        List<Event> events = eventRepository.findByUserGroupAndDay(
                SecurityUtils.getCurrentUser().getUserGroup(),
                DayOfWeek.valueOf(interval.toUpperCase()));
        return generateTimetable(events);
    }

    private Map<UserGroup, List<Event>> getEventsByDay(String interval) {
        List<Event> events = eventRepository.findByDay(DayOfWeek.valueOf(interval));
        return generateTimetable(events);
    }

    private Map<UserGroup, List<Event>> getEvents() {
        List<Event> events = eventRepository.findAll();
        return generateTimetable(events);
    }

    private Map<UserGroup, List<Event>> generateTimetable(List<Event> events) {
        Map<UserGroup, List<Event>> timetable = new HashMap<>();
        events.forEach(event -> {
            UserGroup userGroup = event.getUserGroup();
            if (!isNull(timetable.get(userGroup))) {
                timetable.get(userGroup).add(event);
            } else {
                List<Event> groupEvents = new ArrayList<>();
                groupEvents.add(event);
                timetable.put(event.getUserGroup(), groupEvents);
            }
        });
        return timetable;
    }

}