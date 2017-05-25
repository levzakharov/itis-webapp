package com.itis.controller;

import com.itis.Application;
import com.itis.form.RequestCreationForm;
import com.itis.model.Request;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.RequestService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maratgatin on 24/05/2017.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL)
public class DocumentsController {

    private static final String TEMPLATES_FOLDER = "documents/";

    private final RequestService requestService;

    @Autowired
    public DocumentsController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public String getDocumentsPage(Model model) {
        if (SecurityUtils.getCurrentUser().hasRole(Role.WORKER)) {
            model.addAttribute("documents", requestService.getPendingRequests());
            return TEMPLATES_FOLDER + "index-dean";
        }
        model.addAttribute("documents", requestService.getUserRequests());
        return TEMPLATES_FOLDER + "index";
    }

    @PostMapping
    public String createDocumentRequest(RequestCreationForm form) {
        requestService.createRequest(form);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_DOCUMENTS_URL;
    }


}
