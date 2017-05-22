package com.itis.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author softi on 06.05.2017.
 */
public class PostCreationForm {

    @NotNull(message = "Отсутствует заголовок")
    private String title;

    @NotNull(message = "Пустой текст")
    private String text;

    private List<MultipartFile> images;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
