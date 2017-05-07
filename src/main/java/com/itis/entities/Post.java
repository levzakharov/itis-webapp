package com.itis.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by softi on 01.05.2017.
 */
@Entity
@Table(name = "post", schema = "public", catalog = "isit-portal")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_sequence")
    @SequenceGenerator(name = "post_id_sequence", sequenceName = "post_seq", allocationSize = 1)
    int id;

    int user_id;

    String title;
    String text;

    @Temporal(TemporalType.TIMESTAMP)
    Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
