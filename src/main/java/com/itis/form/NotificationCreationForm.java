package com.itis.form;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author alt
 */
public class NotificationCreationForm {

    @NotBlank(message = "Отстутствует тема")
    private String theme;

    @NotBlank(message = "Отстутствует текст уведомления")
    private String text;

    private List<String> groups;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
}
