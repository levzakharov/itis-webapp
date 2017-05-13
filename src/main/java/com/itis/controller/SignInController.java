package com.itis.controller;

import com.itis.utils.ApplicationUrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rus on 13.05.2017.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.SIGN_IN)
public class SignInController {
    public String signInPage() {
        return "signIn";
    }
}
