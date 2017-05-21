package com.itis.form;

import javax.validation.constraints.NotNull;

/**
 * @author softi on 06.05.2017.
 */
public class PostCreationForm {

    @NotNull(message = "Отсутствует заголовок")
    private String title;

    @NotNull(message = "Пустой текст")
    private String text;

    @NotNull(message = "Нет действия")
    private String action;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
