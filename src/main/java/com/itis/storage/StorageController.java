package com.itis.storage;

import com.itis.storage.StorageService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by softi on 15.05.2017.
 */
@Controller
@EnableAutoConfiguration
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping(value = ApplicationUrls.WebAppUrls.FILE_URL)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String fileName) {

        Resource file = storageService.loadAsResource(fileName);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
