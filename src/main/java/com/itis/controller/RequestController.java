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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author r.khakov
 */
@Controller
public class RequestController {
    private static final String TEMPLATES_FOLDER = "certificates/";

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping(ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL)
    public String getRequestsPage(Model model) {
        System.out.println(ApplicationUrls.WebAppUrls.CREATE_REQUEST_URL);

        if (SecurityUtils.getCurrentUser().hasRole(Role.WORKER)) {
            model.addAttribute("pending_requests", requestService.getPendingRequests());
            return TEMPLATES_FOLDER + "index-dean";
        }
        model.addAttribute("request_creation_form", new RequestCreationForm());
        model.addAttribute("requests", requestService.getCurrentUserRequests());
        return TEMPLATES_FOLDER + "index";
    }

    @PostMapping(ApplicationUrls.WebAppUrls.CREATE_REQUEST_URL)
    public String createRequest(@ModelAttribute("request_creation_form") RequestCreationForm form) {
        requestService.createRequest(form);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL;
    }

    @PostMapping(ApplicationUrls.WebAppUrls.ACCEPT_REQUEST_URL)
    public String acceptRequest(@PathVariable long requestId) {
        requestService.acceptRequest(requestId);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL;
    }

    @PostMapping(ApplicationUrls.WebAppUrls.DECLINE_REQUEST_URL)
    public String declineRequest(@PathVariable long requestId) {
        requestService.declineRequest(requestId);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_REQUESTS_URL;
    }
}
