package com.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rus on 13.05.2017.
 */
@Controller
@RequestMapping("/signIn")
public class SignInController {
    @GetMapping
    public String signInPage() {
        return "signIn";
    }
}
