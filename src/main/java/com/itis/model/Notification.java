package com.itis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author alt
 */
@Entity
@Table(name = "notification")
@SequenceGenerator(name = "notification_seq",
        sequenceName = "notification_seq", allocationSize = 1, initialValue = 50)
public class Notification {

    @Id
    @GeneratedValue(generator = "notification_seq")
    private Long id;

    private String theme;

    private String text;

    private Long date;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        return Objects.equals(id, that.id) &&
                (theme != null ? theme.equals(that.theme) : that.theme == null) &&
                (text != null ? text.equals(that.text) : that.text == null) &&
                (date != null ? date.equals(that.date) : that.date == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
