package com.itis.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public interface StorageService {

    String store(MultipartFile file);

    Path load(String filename);

    Resource loadAsResourceFile(String filename);

    Resource loadAsResource(Path file);

    Resource loadAsResourceDocument(String documentName);

    void deleteAll();

}