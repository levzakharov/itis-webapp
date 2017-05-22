package com.itis.service;

import com.itis.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by softi on 15.05.2017.
 */
public interface ImageService {

    Image createImage(String name);

}
