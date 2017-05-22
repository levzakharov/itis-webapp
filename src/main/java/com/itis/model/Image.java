package com.itis.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by softi on 15.05.2017.
 */
@Entity
@Table(name = "image", schema = "public")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_sequence")
    @SequenceGenerator(name = "image_id_sequence", sequenceName = "image_seq", allocationSize = 1, initialValue = 50)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "images")
    private List<Post> posts;

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
