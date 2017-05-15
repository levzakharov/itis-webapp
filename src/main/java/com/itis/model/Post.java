package com.itis.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

/**
 * Created by softi on 01.05.2017.
 */
@Entity
@Table(name = "post", schema = "public")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_sequence")
    @SequenceGenerator(name = "post_id_sequence", sequenceName = "post_seq", allocationSize = 1, initialValue = 50)
    private Long id;
    private String title;
    private String text;

    private long date;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String image;


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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
