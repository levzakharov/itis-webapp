package com.itis.controller;

import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.UserService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by maratgatin on 27/05/2017.
 */
@Controller

public class AccountsManagementController {

    private final UserService userService;

    private final String TEMPLATES_FOLDER = "accounts_management/";

    @Autowired
    public AccountsManagementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApplicationUrls.WebAppUrls.BASE_ACCOUNTS_MANAGEMENT_URL)
    public String getAccountsPage(ModelMap modelMap) {
        if (SecurityUtils.getCurrentUser().hasRole(Role.ADMIN)) {
            modelMap.put("users", userService.getAllUsersExceptingAdmin());
            return TEMPLATES_FOLDER + "accounts";
        } else {
            return "redirect:" + ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
        }
    }

    @PostMapping(ApplicationUrls.WebAppUrls.BAN_ACCOUNT_URL)
    public String banUser(@PathVariable long userId) {
        userService.ban(userId);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_ACCOUNTS_MANAGEMENT_URL;
    }

    @PostMapping(ApplicationUrls.WebAppUrls.UNBAN_ACCOUNT_URL)
    public String unbanUser(@PathVariable long userId) {
        userService.unban(userId);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_ACCOUNTS_MANAGEMENT_URL;
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.CREATE_ACCOUNT_URL)
    public String createUsersWithCsvFile(MultipartFile file) {
        userService.createUsers(file);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_ACCOUNTS_MANAGEMENT_URL;
    }
}