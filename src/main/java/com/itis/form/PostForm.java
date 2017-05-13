package com.itis.form;

/**
 * Created by softi on 06.05.2017.
 */
public class PostForm {
    private String Title;
    private String Text;
    private String action;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
