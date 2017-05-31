package com.itis.controller;

import com.itis.utils.ApplicationUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by softi on 31.05.2017.
 */
@Controller
public class AccountController {

    @GetMapping(value = ApplicationUrls.WebAppUrls.ACCOUNTS_MANAGEMENT_URL)
    public String getAcctountsPage() {
        return "account/management";
    }
}
