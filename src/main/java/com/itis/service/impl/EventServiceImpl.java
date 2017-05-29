package com.itis.service.impl;

import com.itis.criteria.TimetableSearchCriteria;
import com.itis.exceptions.TimetableCreationException;
import com.itis.form.EventParsingForm;
import com.itis.model.Event;
import com.itis.model.UserGroup;
import com.itis.model.enums.EventInterval;
import com.itis.repository.EventRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.EventService;
import com.itis.transformers.EventParsingFormToEventTransformer;
import com.itis.utils.CSVParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.*;

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
    private EventParsingFormToEventTransformer transformer;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Map<DayOfWeek, Map<EventInterval, List<Event>>> getTimetable(TimetableSearchCriteria criteria) {
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
            eventRepository.deleteAll();
            Set<EventParsingForm> eventParsingForms = CSVParser.parse(file.getBytes(), EventParsingForm.class);
//            Set<EventParsingForm> eventParsingForms = CSVParser.parse(file.getBytes(), EventParsingForm.class);
            eventParsingForms.forEach(eventParsingForm -> {
                Event event = transformer.apply(eventParsingForm);
                eventRepository.save(event);
            });
        } catch (IOException e) {
            LOGGER.error("error occured while parsing csv file to timetable events : ", e);
            throw new TimetableCreationException();
        }
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    private Map<DayOfWeek, Map<EventInterval, List<Event>>> getEventsByUserGroup() {
        List<Event> events = eventRepository
                .findByUserGroup(SecurityUtils.getCurrentUser().getUserGroup());
        return generateTimetable(events);
    }

    private Map<DayOfWeek, Map<EventInterval, List<Event>>> getEventsByUserGroupAndDay(String interval) {
        List<Event> events = eventRepository.findByUserGroupAndDay(
                SecurityUtils.getCurrentUser().getUserGroup(),
                DayOfWeek.valueOf(interval.toUpperCase()));
        return generateTimetable(events);
    }

    private Map<DayOfWeek, Map<EventInterval, List<Event>>> getEventsByDay(String interval) {
        List<Event> events = eventRepository.findByDay(DayOfWeek.valueOf(interval.toUpperCase()));
        return generateTimetable(events);
    }

    private Map<DayOfWeek, Map<EventInterval, List<Event>>> getEvents() {
        List<Event> events = eventRepository.findAll();
        return generateTimetable(events);
    }

    private Map<DayOfWeek, Map<EventInterval, List<Event>>> generateTimetable(List<Event> events) {
        Map<DayOfWeek, Map<EventInterval, List<Event>>> timetable = new TreeMap<>();

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            timetable.put(dayOfWeek, new TreeMap<>());
            for (EventInterval eventInterval : EventInterval.values()) {
                timetable.get(dayOfWeek).put(eventInterval, new ArrayList<>());
            }
        }

        events.forEach(event -> {
            timetable.get(event.getDay()).get(event.getInterval()).add(event);
        });
        return timetable;
    }


}