package com.itis.model;

import javax.persistence.*;

/**
 * @author r.khakov
 */
@Entity
@Table(name = "decrees")
@SequenceGenerator(name = "decrees_seq",
        sequenceName = "decrees_seq", allocationSize = 1, initialValue = 50)
public class Decree {

    @Id
    @GeneratedValue(generator = "decrees_seq")
    private Long id;

    private String text;

    @Column(name = "starts_year")
    private Integer startsYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStartsYear() {
        return startsYear;
    }

    public void setStartsYear(Integer startsYear) {
        this.startsYear = startsYear;
    }
}