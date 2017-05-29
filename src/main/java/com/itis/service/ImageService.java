package com.itis.service;

import com.itis.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author softi on 15.05.2017.
 */
public interface ImageService {

    Image create(MultipartFile multipartFile);

    List<Image> create(List<MultipartFile> multipartFiles);
}