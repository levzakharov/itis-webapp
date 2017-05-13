package com.itis.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public class EventCreationForm {

    @NotNull(message = "неверный номер")
    private String number;

    @NotNull(message = "неверная дата проведения")
    private Date date;

    @NotNull(message = "отсутствует описание")
    private String description;

    @NotNull(message = "отсутствует место проведения")
    private String place;

    public EventCreationForm(String number, Date date, String description, String place) {
        this.number = number;
        this.date = date;
        this.description = description;
        this.place = place;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
