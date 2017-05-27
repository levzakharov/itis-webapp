package com.itis.controller;

import com.itis.form.RequestCreationForm;
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
 * @author r.khakov
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL)
public class RequestController {
    private static final String TEMPLATES_FOLDER = "certificates/";

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public String getRequestsPage(Model model) {
        if (SecurityUtils.getCurrentUser().hasRole(Role.WORKER)) {
            model.addAttribute("documents", requestService.getPendingRequests());
            return TEMPLATES_FOLDER + "index-dean";
        }
        model.addAttribute("documents", requestService.getUserRequests());
        return TEMPLATES_FOLDER + "index";
    }

    @PostMapping
    public String createRequest(RequestCreationForm form) {
        requestService.createRequest(form);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL;
    }
}
