package com.itis.controller;

import com.itis.form.DocumentCreationForm;
import com.itis.service.DocumentService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by softi on 24.05.2017.
 */
@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping(value = ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL)
    public String getDocumentsPage(ModelMap modelMap) {
        modelMap.put("documents", documentService.getAll());
        return "document/index";
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.CREATE_DOCUMENT_URL)
    public String createDocument(DocumentCreationForm documentCreationForm) {
        documentService.create(documentCreationForm);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL;
    }
}
