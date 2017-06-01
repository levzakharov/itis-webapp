package com.itis.service.impl;

import com.itis.model.Image;
import com.itis.repository.ImageRepository;
import com.itis.service.ImageService;
import com.itis.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author softi on 19.05.2017.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final StorageService storageService;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, StorageService storageService) {
        this.imageRepository = imageRepository;
        this.storageService = storageService;
    }

    public Image create(MultipartFile multipartFile) {
        if (!multipartFile.getContentType().matches("image/.+")) {
            throw new IllegalArgumentException("Incorrect format of image");
        }
        Image image = new Image();
        image.setTitle(storageService.store(multipartFile));
        return imageRepository.save(image);
    }

    @Override
    public List<Image> create(List<MultipartFile> multipartFiles) {
        List<Image> images = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            images.add(create(multipartFile));
        }
        return images;
    }
}