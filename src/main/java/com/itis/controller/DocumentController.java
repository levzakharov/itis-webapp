package com.itis.controller;

import com.itis.form.DocumentCreationForm;
import com.itis.model.Document;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.service.DocumentService;
import com.itis.service.UserService;
import com.itis.utils.ApplicationUrls;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 24.05.2017.
 */
@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private UserService userService;

    @GetMapping(value = ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL)
    public String getDocumentsPage() {
        return "document/navigate";
    }

    @GetMapping(value = ApplicationUrls.WebAppUrls.TEACHER_FOLDERS_URL)
    public String getTeacherFoldersPage(ModelMap modelMap) {
        modelMap.put("users", userService.getByRole(Role.TEACHER));
        return "document/folder";
    }

    @GetMapping(value = ApplicationUrls.WebAppUrls.TEACHER_DOCUMENTS_URL)
    public String getTeacherDocumentsPage(@PathVariable int userId, ModelMap modelMap ) {
        modelMap.put("documents", documentService.getByUserId(userId));
        return "document/index";
    }

    @GetMapping(value = ApplicationUrls.WebAppUrls.DEAN_DOCUMENTS_URK)
    public String getDeanDocumentsPage(ModelMap modelMap) {
        List<Document> documents = new ArrayList<>();
        List<User> users = userService.getByRole(Role.WORKER);
        users.addAll(userService.getByRole(Role.ADMIN));
        for (User user : users) {
            documents.addAll(documentService.getByUserId(user.getId()));
        }
        modelMap.put("documents", documents);
        return "document/index";
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.CREATE_DOCUMENT_URL)
    public String createDocument(DocumentCreationForm documentCreationForm) {
        documentService.create(documentCreationForm);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL;
    }
}
