package com.itis.form;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author alt
 */
public class NotificationCreationForm {

    @NotNull(message = "отстутствует тема")
    private String theme;

    @NotNull(message = "отстутствует текст уведомления")
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
