package com.itis.service;

import com.itis.model.Event;
import com.itis.model.User;

import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface EventService {

    List<Event> getEventsByUser(User user);

    List<Event> getCurrentUserEvents();

    Event getOne(Long id);

}
