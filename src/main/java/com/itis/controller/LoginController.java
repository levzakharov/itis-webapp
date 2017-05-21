package com.itis.controller;

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

    private static final String LOGIN_PAGE = "login";

    @GetMapping(value = LOGIN)
    public String getLoginPage(@RequestParam(name = "error", required = false) Boolean error,
                               Model model) {
        if (error != null && error) {
            model.addAttribute("error", true);
        }
        return LOGIN_PAGE;
    }

}
