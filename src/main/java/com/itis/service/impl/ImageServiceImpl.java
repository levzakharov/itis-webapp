package com.itis.service.impl;

import com.itis.model.Image;
import com.itis.repository.ImageRepository;
import com.itis.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 19.05.2017.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image createImage(String name) {
        Image image = new Image();
        image.setTitle(name);
        return imageRepository.save(image);
    }
}
