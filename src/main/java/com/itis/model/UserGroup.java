package com.itis.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Entity
@Table(name = "user_group")
@SequenceGenerator(name = "user_group_gen",
        sequenceName = "user_group_seq", allocationSize = 1, initialValue = 50)
public class UserGroup {

    @Id
    @GeneratedValue(generator = "user_group_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String number;

    @Column(name = "start_year")
    private Integer startYear;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_group_id")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}