package com.itis.form;

import javax.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public class EventCreationForm {

    @NotNull(message = "неверный номер")
    private String number;

    @NotNull(message = "неверный день")
    private String day;

    @NotNull(message = "отсутствует описание")
    private String description;

    @NotNull(message = "отсутствует место проведения")
    private String place;

    public EventCreationForm(String number, DayOfWeek day, String description, String place) {
        this.number = number;
        this.day = day.toString();
        this.description = description;
        this.place = place;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
