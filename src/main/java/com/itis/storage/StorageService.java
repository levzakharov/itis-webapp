package com.itis.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;


public interface StorageService {

    String store(MultipartFile file);

    Path load(String filename);

    Resource loadAsResourceFile(String filename);

    Resource loadAsResource(Path file);

    Resource loadAsResourceDocument(String documentName);

    void deleteAll();

}
