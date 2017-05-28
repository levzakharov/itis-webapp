package com.itis.controller;

import com.itis.form.RequestCreationForm;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.RequestService;
import com.itis.service.UserService;
import com.itis.utils.ApplicationUrls;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author r.khakov
 */
@Controller
public class RequestController {

    private static final String TEMPLATES_FOLDER = "certificates/";

    private final RequestService requestService;
    private final UserService userService;

    @Autowired
    public RequestController(RequestService requestService, UserService userService) {
        this.requestService = requestService;
        this.userService = userService;
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

    @GetMapping(ApplicationUrls.WebAppUrls.ACCEPTED_REQUESTS_URL)
    public String getAcceptedRequestsPage(Model model) {
        model.addAttribute("accepted_requests", requestService.getAcceptedRequests());
        return TEMPLATES_FOLDER + "index-dean-accepted";
    }

    @GetMapping(ApplicationUrls.WebAppUrls.DECLINED_REQUESTS_URL)
    public String getDeclinedRequestsPage(Model model) {
        model.addAttribute("declined_requests", requestService.getDeclinedRequests());
        return TEMPLATES_FOLDER + "index-dean-declined";
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

    @GetMapping(value = "/document", produces = "application/docx")
    @ResponseBody
    public FileSystemResource getPdf(HttpServletResponse response) throws DocumentException, IOException {
        User user = userService.getByRole(Role.STUDENT).get(2);
        response.setHeader("Content-Disposition", "attachment; filename=" + '"' + user.getFullName() + ".docx" + '"');
        return new FileSystemResource(requestService.generateCertificate(user));
    }
}
