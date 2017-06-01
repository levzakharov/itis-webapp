package com.itis.form;

import com.itis.model.enums.EventInterval;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.DayOfWeek;

/**
 * @author softi on 28.05.2017.
 */
public class EventParsingForm {
    private String description;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    @Enumerated(EnumType.STRING)
    private EventInterval interval;

    private String place;

    private String userGroup;

    private String name;

    private Long teacher;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public EventInterval getInterval() {
        return interval;
    }

    public void setInterval(EventInterval interval) {
        this.interval = interval;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }
}