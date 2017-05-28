package com.itis.transformers;

import com.itis.form.EventParsingForm;
import com.itis.model.Event;
import com.itis.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.function.Function;

/**
 * Created by softi on 28.05.2017.
 */
@Component
public class EventParsingFormToEventTransformer implements Function<EventParsingForm, Event> {

    @Autowired
    private UserGroupService userGroupService;

    @Override
    public Event apply(EventParsingForm eventParsingForm) {
        Event event = new Event();
        event.setDescription(eventParsingForm.getDescription());
        event.setPlace(eventParsingForm.getPlace());
        event.setDay(eventParsingForm.getDay());
        event.setName(eventParsingForm.getName());
        event.setInterval(eventParsingForm.getInterval());
        event.setUserGroup(userGroupService.getUserGroup(eventParsingForm.getUserGroup()));
        return event;
    }
}
