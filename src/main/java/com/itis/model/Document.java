package com.itis.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by softi on 23.05.2017.
 */
@Entity
@Table(name = "document", schema = "public")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_sequence")
    @SequenceGenerator(name = "image_id_sequence", sequenceName = "image_seq", allocationSize = 1, initialValue = 50)
    private Long id;
    private String name;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(mappedBy = "documents")
    private List<Post> documents;

    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Post> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Post> documents) {
        this.documents = documents;
    }
}
