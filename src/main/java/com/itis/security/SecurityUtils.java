package com.itis.security;

import com.itis.model.User;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public class SecurityUtils {

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}