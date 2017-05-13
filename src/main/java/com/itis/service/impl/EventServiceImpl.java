package com.itis.service.impl;

import com.itis.model.Event;
import com.itis.model.User;
import com.itis.model.UserGroup;
import com.itis.repository.EventRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

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
}
