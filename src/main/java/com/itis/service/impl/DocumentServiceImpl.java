package com.itis.service.impl;

import com.itis.form.DocumentCreationForm;
import com.itis.model.Document;
import com.itis.repository.DocumentRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.DocumentService;
import com.itis.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author softi on 23.05.2017.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;
    private StorageService storageService;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, StorageService storageService) {
        this.documentRepository = documentRepository;
        this.storageService = storageService;
    }

    @Override
    public Document create(MultipartFile multipartFile) {
        Document document = new Document();
        document.setName(multipartFile.getOriginalFilename());
        document.setPath(storageService.store(multipartFile));
        document.setUser(SecurityUtils.getCurrentUser());
        return documentRepository.save(document);
    }

    public List<Document> create(List<MultipartFile> multipartFiles) {
        List<Document> documents = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            documents.add(create(multipartFile));
        }
        return documents;
    }

    public List<Document> create(DocumentCreationForm documentCreationForm) {
        return create(documentCreationForm.getDocuments());
    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> getByUserId(long userId) {
        return documentRepository.findByUserId(userId);
    }

    @Override
    public Document getById(long documentId) {
        return documentRepository.findOne(documentId);
    }

    @Override
    public void delete(Document document) {
        storageService.delete(document.getPath());
        documentRepository.delete(document);
    }
}