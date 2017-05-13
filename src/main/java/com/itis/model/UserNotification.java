package com.itis.model;

import javax.persistence.*;

/**
 * @author alt
 */
@Entity
@Table(name = "user_notification")
@SequenceGenerator(name = "user_notification_seq",
        sequenceName = "user_notification_seq", allocationSize = 1, initialValue = 50)
public class UserNotification {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @Column(name = "is_read")
    private boolean isRead;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserNotification that = (UserNotification) o;

        if (isRead != that.isRead) return false;
        if (!user.equals(that.user)) return false;
        return notification.equals(that.notification);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + notification.hashCode();
        result = 31 * result + (isRead ? 1 : 0);
        return result;
    }
}
