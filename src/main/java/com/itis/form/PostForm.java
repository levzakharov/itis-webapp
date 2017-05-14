package com.itis.form;

import javax.validation.constraints.NotNull;

/**
 * Created by softi on 06.05.2017.
 */
public class PostForm {
    private String Title;
    private String Text;
    private String action;

    @NotNull
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @NotNull
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    @NotNull
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
