package com.itis.service.impl;

import com.itis.model.Event;
import com.itis.model.User;
import com.itis.model.UserGroup;
import com.itis.repository.EventRepository;
import com.itis.repository.UserGroupRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Service
public class EventServiceImpl implements EventService {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("E");

    private final EventRepository eventRepository;

    private final UserGroupRepository userGroupRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, UserGroupRepository userGroupRepository) {
        this.eventRepository = eventRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public List<Event> getEventsByUser(User user) {
        return eventRepository.findByUser(user);
    }

    @Override
    public List<Event> getCurrentUserEvents() {
        return getEventsByUser(SecurityUtils.getCurrentUser());
    }

    @Override
    public List<Event> getScheduleByGroup(UserGroup userGroup) {
        return null;
    }

    @Override
    public Event getOne(Long id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Map<UserGroup, Map<String, List<Event>>> getScheduleBetween(Long startDate,
                                                                       Long endDate) {
        return generateSchedule(
                eventRepository.findByDateGreaterThanAndDateLessThan(startDate, endDate));
    }

    @Override
    public Map<String, List<Event>> getScheduledBetweenByGroup(Long startDate,
                                                               Long endDate,
                                                               Long userGroupId) {
        return getScheduleBetween(startDate, endDate)
                .get(userGroupRepository.findOne(userGroupId));
    }

    private Map<UserGroup, Map<String, List<Event>>> generateSchedule(List<Event> events) {
        Map<UserGroup, Map<String, List<Event>>> schedule = new HashMap<>();
        events.forEach(event -> event.getUsers().forEach(user -> {
                    UserGroup userGroup = user.getUserGroup();
                    String dayOfWeek = SIMPLE_DATE_FORMAT.format(event.getDate());
                    if (!schedule.get(userGroup).get(dayOfWeek).contains(event)) {
                        schedule.get(userGroup).get(dayOfWeek).add(event);
                    }
                }
        ));
        return schedule;
    }
}