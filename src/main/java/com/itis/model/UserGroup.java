package com.itis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

    private String name;

    @Column(name = "start_year")
    private Integer startYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userGroup")
    private List<User> users;

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