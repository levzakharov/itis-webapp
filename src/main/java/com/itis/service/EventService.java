package com.itis.service;

import com.itis.model.Event;
import com.itis.model.User;
import com.itis.model.UserGroup;

import java.util.List;
import java.util.Map;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface EventService {

    List<Event> getEventsByUser(User user);

    List<Event> getCurrentUserEvents();

    List<Event> getScheduleByGroup(UserGroup userGroup);

    Event getOne(Long id);

    Map<UserGroup, Map<String, List<Event>>> getScheduleBetween(Long startDate, Long endDate);

    Map<String, List<Event>> getScheduledBetweenByGroup(Long startDate, Long endDate, UserGroup userGroup);
}
