package com.itis.controller;

import com.itis.service.UserGroupService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by softi on 31.05.2017.
 */
@Controller
public class AccountController {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping(value = ApplicationUrls.WebAppUrls.ACCOUNTS_MANAGEMENT_URL + "/ilnur")
    public String getAcctountsPage(ModelMap modelMap) {

        return "account/management";
    }
}
