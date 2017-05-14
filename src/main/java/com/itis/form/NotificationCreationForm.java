package com.itis.form;

import javax.validation.constraints.NotNull;

/**
 * @author alt
 */
public class NotificationCreationForm {

    @NotNull(message = "отстутствует тема")
    private String theme;

    @NotNull(message = "отстутствует текст уведомления")
    private String text;


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
}
