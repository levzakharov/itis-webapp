package com.itis.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by softi on 01.05.2017.
 */
@Entity
@Table(name = "post", schema = "public")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_sequence")
    @SequenceGenerator(name = "post_id_sequence", sequenceName = "post_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
