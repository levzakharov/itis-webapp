package com.itis.controller;

import com.itis.form.RequestCreationForm;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.RequestService;
import com.itis.service.UserService;
import com.itis.storage.StorageService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author r.khakov
 */
@Controller
public class RequestController {

    private static final String TEMPLATES_FOLDER = "certificates/";

    private final RequestService requestService;
    private final UserService userService;
    private final StorageService storageService;

    @Autowired
    public RequestController(RequestService requestService,
                             UserService userService, StorageService storageService) {
        this.requestService = requestService;
        this.userService = userService;
        this.storageService = storageService;
    }

    @GetMapping(ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL)
    public String getRequestsPage(Model model) {

        if (SecurityUtils.getCurrentUser().hasRole(Role.WORKER)) {
            model.addAttribute("pending_requests", requestService.getPendingRequests());
            return TEMPLATES_FOLDER + "index-dean";
        }
        model.addAttribute("request_creation_form", new RequestCreationForm());
        model.addAttribute("requests", requestService.getCurrentUserRequests());
        return TEMPLATES_FOLDER + "index";
    }

    @GetMapping(ApplicationUrls.WebAppUrls.PROCESSED_REQUESTS_URL)
    public String getProcessedRequestsPage(Model model) {
        model.addAttribute("processed_requests", requestService.getProcessedRequests());
        return TEMPLATES_FOLDER + "index-dean-processed";
    }

    @PostMapping(ApplicationUrls.WebAppUrls.CREATE_REQUEST_URL)
    public String createRequest(@ModelAttribute("request_creation_form") RequestCreationForm form) {
        requestService.createRequest(form);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL;
    }

    @ResponseBody
    @PostMapping(ApplicationUrls.WebAppUrls.ACCEPT_REQUEST_URL)
    public String acceptRequest(@PathVariable long requestId) {
        requestService.acceptRequest(requestId);
        return "success";
    }

    @ResponseBody
    @PostMapping(ApplicationUrls.WebAppUrls.DECLINE_REQUEST_URL)
    public String declineRequest(@PathVariable long requestId) {
        requestService.declineRequest(requestId);
        return "success";
    }

    @GetMapping(value = ApplicationUrls.WebAppUrls.GENERATE_CERTIFICATE_URL, produces = "application/docx")
    @ResponseBody
    public ResponseEntity<Resource> generateCertificate(@PathVariable long requestId) {

        Resource file = storageService.loadAsResourceDocument(requestService.generateCertificate(requestId));
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}