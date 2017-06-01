package com.itis.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.itis.model.enums.EventInterval;

import javax.persistence.*;
import java.time.DayOfWeek;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Entity
@Table(name = "event")
@SequenceGenerator(name = "event_gen",
        sequenceName = "event_seq", allocationSize = 1, initialValue = 50)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_gen")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    @Enumerated(EnumType.STRING)
    private EventInterval interval;

    private String place;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    private User teacher;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public EventInterval getInterval() {
        return interval;
    }

    public void setInterval(EventInterval interval) {
        this.interval = interval;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}