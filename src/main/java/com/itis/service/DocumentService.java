package com.itis.service;

import com.itis.model.Document;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by softi on 23.05.2017.
 */
public interface DocumentService {
    Document createDocument(MultipartFile multipartFile);

}
