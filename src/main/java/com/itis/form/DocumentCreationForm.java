package com.itis.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author softi on 06.05.2017.
 */
public class DocumentCreationForm {

    @NotNull(message = "Отсутствуют документы")
    private List<MultipartFile> documents;

    public List<MultipartFile> getDocuments() {
        return documents;
    }

    public void setDocuments(List<MultipartFile> documents) {
        this.documents = documents;
    }
}