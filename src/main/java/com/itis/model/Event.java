package com.itis.model;

import javax.persistence.*;
import java.util.List;

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

    private String number;

    private String description;

    private Long date;

    private String place;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "event_user",
            joinColumns = @JoinColumn(name = "event_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setPlace(String place) {
        this.place = place;

    }
}
