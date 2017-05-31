package com.itis.controller;

import com.itis.service.UserGroupService;
import com.itis.service.UserService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by softi on 31.05.2017.
 */
@Controller
public class AccountController {

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private UserService userService;

    @GetMapping(value = ApplicationUrls.WebAppUrls.ACCOUNTS_MANAGEMENT_URL)
    public String getAcctountsPage(ModelMap modelMap) {
        modelMap.put("userGroups", userGroupService.getUserGroups());
        return "account/management";
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.CREATE_ACCOUNT_URL)
    public String createUsersWithCsvFile(MultipartFile file) {
        userService.createUsers(file);
        return "redirect:" + ApplicationUrls.WebAppUrls.ACCOUNTS_MANAGEMENT_URL;
    }
}
