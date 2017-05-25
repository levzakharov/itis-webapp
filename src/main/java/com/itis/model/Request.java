package com.itis.model;

import com.itis.model.enums.RequestStatus;

import javax.persistence.*;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
@Entity
@Table(name = "request")
@SequenceGenerator(name = "request_gen",
        sequenceName = "request_seq", allocationSize = 1, initialValue = 50)
public class Request {

    @Id
    @GeneratedValue(generator = "request_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String theme;

    private String text;

    private Long date;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
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

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
