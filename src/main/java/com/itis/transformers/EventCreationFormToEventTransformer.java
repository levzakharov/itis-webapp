package com.itis.transformers;

import com.itis.form.EventCreationForm;
import com.itis.model.Event;

import java.util.function.Function;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public class EventCreationFormToEventTransformer implements Function<EventCreationForm, Event> {
    @Override
    public Event apply(EventCreationForm eventCreationForm) {
        Event event = new Event();
        event.setDescription(eventCreationForm.getDescription());
        event.setPlace(eventCreationForm.getPlace());
        event.setNumber(eventCreationForm.getNumber());
        event.setDate(eventCreationForm.getDate().getTime());
        return event;
    }
}
