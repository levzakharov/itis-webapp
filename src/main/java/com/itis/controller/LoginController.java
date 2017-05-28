package com.itis.controller;

import com.itis.utils.ApplicationUrls;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.itis.utils.ApplicationUrls.WebAppUrls.LOGIN;

/**
 * @author Rus on 13.05.2017.
 */
@Controller
public class LoginController {

    private static final String LOGIN_PAGE = ApplicationUrls.WebAppUrls.LOGIN;

    @GetMapping(value = LOGIN)
    public String getLoginPage(@RequestParam(name = "error", required = false) Boolean error,
                               Model model) {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return "redirect:" + ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
        }

        if (error != null && error) {
            model.addAttribute("error", true);
        }
        return LOGIN_PAGE;
    }
}