package com.itis.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by softi on 06.05.2017.
 */
public class PostCreationForm {
    private String Title;
    private String Text;
    private List<MultipartFile> images;

    @NotNull(message = "Отсутствует заголовок")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @NotNull(message = "Пустой текст")
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }


    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
