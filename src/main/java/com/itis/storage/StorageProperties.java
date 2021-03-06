package com.itis.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private static final String LOCATION = "src/main/resources/upload-dir";

    private static final String DOCUMENT_LOCATION = "src/main/resources/upload-dir";

    public String getLocation() {
        return LOCATION;
    }

    public String getDocumentLocation() {
        return DOCUMENT_LOCATION;
    }
}