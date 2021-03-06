package com.itis.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Entity
@Table(name = "user_group")
@SequenceGenerator(name = "user_group_gen",
        sequenceName = "user_group_seq", allocationSize = 1, initialValue = 50)
public class UserGroup implements Comparable {

    @Id
    @GeneratedValue(generator = "user_group_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String number;

    @Column(name = "start_year")
    private Integer startYear;

    @OneToMany(mappedBy = "userGroup")
    @JsonIgnore
    private List<Event> events;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_group_id")
    @JsonIgnore
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        String num1 = this.getNumber();
        String num2 = ((UserGroup) o).getNumber();
        String course1 = num1.substring(0, 4);
        String group1 = num1.substring(4);
        String course2 = num2.substring(0, 4);
        String group2 = num2.substring(4);
        if (course1.equals(course2)) {
            return group2.compareTo(group1);
        }
        return course1.compareTo(course2);
    }

}