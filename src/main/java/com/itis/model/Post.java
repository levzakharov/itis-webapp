package com.itis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author softi on 01.05.2017.
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

    @ManyToMany
    @JoinTable(name = "post_image", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns =
    @JoinColumn(name = "image_id"))
    @JsonIgnore
    private List<Image> images;

    @ManyToMany
    @JoinTable(name = "document_post", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns =
    @JoinColumn(name = "document_id"))
    @JsonIgnore
    private List<Document> documents;

    private long date;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}