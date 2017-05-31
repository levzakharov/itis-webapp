package com.itis.controller;

import com.itis.form.DocumentCreationForm;
import com.itis.model.Document;
import com.itis.model.Post;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.DocumentService;
import com.itis.service.UserService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author softi on 24.05.2017.
 */
@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final UserService userService;

    @Autowired
    public DocumentController(DocumentService documentService, UserService userService) {
        this.documentService = documentService;
        this.userService = userService;
    }

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
    public String getTeacherDocumentsPage(@PathVariable int userId, ModelMap modelMap) {
        boolean isOwner = SecurityUtils.getCurrentUser().getId() == userId;
        User user = userService.getById(userId);
        modelMap.put("documents", documentService.getByUserId(userId));
        modelMap.put("isOwner", isOwner);
        modelMap.put("teacher", user);
        return "document/docs_teacher";
    }

    @GetMapping(value = ApplicationUrls.WebAppUrls.DEAN_DOCUMENTS_URL)
    public String getDeanDocumentsPage(ModelMap modelMap) {
        List<Document> documents = new ArrayList<>();
        List<User> users = userService.getByRole(Role.WORKER);
        users.addAll(userService.getByRole(Role.ADMIN));
        for (User user : users) {
            documents.addAll(documentService.getByUserId(user.getId()));
        }
        modelMap.put("documents", documents);
        return "document/docs_dean";
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.CREATE_DOCUMENT_URL)
    public String createDocument(DocumentCreationForm documentCreationForm) {
        documentService.create(documentCreationForm);
        User user = SecurityUtils.getCurrentUser();
        if (user.getRoles().contains(Role.ADMIN) || user.getRoles().contains(Role.WORKER)) {
            return "redirect:" + ApplicationUrls.WebAppUrls.DEAN_DOCUMENTS_URL;
        } else if (user.getRoles().contains(Role.TEACHER)) {
            return "redirect:" + ApplicationUrls.WebAppUrls.TEACHER_FOLDERS_URL + "/" + user.getId();
        }
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL;
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.DELETE_DOCUMENT_URL)
    public String deletePost(@PathVariable long documentId) {
        Document document = documentService.getById(documentId);
        documentService.delete(document);

        User user = SecurityUtils.getCurrentUser();
        if (user.getRoles().contains(Role.ADMIN) || user.getRoles().contains(Role.WORKER)) {
            return "redirect:" + ApplicationUrls.WebAppUrls.DEAN_DOCUMENTS_URL;
        } else if (user.getRoles().contains(Role.TEACHER)) {
            return "redirect:" + ApplicationUrls.WebAppUrls.TEACHER_FOLDERS_URL + "/" + user.getId();
        }
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL;

    }
}