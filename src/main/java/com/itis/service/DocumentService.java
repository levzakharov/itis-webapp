package com.itis.service;

import com.itis.form.DocumentCreationForm;
import com.itis.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author softi on 23.05.2017.
 */
public interface DocumentService {

    Document create(MultipartFile multipartFile);

    List<Document> create(List<MultipartFile> multipartFiles);

    List<Document> create(DocumentCreationForm documentCreationForm);

    List<Document> getAll();

    List<Document> getByUserId(long userId);

}