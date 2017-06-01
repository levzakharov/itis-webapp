package com.itis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "message_seq",
        sequenceName = "message_seq", allocationSize = 1, initialValue = 50)
public class Message {
    @Id
    @GeneratedValue(generator = "message_seq")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String content;
    @Column(name = "from_user")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String fromUser;
    @Column(name = "to_user")
    private String toUser;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean unread = true;
    @Column(name = "timestamp", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date timestamp = new Date();

    public Message() {
    }

    public Message(String content, String fromUser, String toUser) {
        this.content = content;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return this.content + "\n" +
                this.fromUser + "\n" +
                this.toUser + "\n";
    }
}
