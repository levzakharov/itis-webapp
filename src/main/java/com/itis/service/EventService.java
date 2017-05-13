package com.itis.service;

import com.itis.model.Event;
import com.itis.model.User;
import com.itis.model.UserGroup;

import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface EventService {

    List<Event> getEventsByUser(User user);

    List<Event> getCurrentUserEvents();

    List<Event> getScheduleByGroup(UserGroup userGroup);

    Event getOne(Long id);

}
