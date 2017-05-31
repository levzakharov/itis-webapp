package com.itis.controller;

import com.itis.utils.ApplicationUrls;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author alt
 */
@Controller
public class ErrorPagesController {

    final String TEMPLATES_FOLDER = "error/";

    @RequestMapping(ApplicationUrls.WebAppErrorsUrls.ERROR_404_URL)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return TEMPLATES_FOLDER + "404";
    }

    @RequestMapping(ApplicationUrls.WebAppErrorsUrls.ERROR_403_URL)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String forbidden() {
        return TEMPLATES_FOLDER + "403";
    }

    @RequestMapping(ApplicationUrls.WebAppErrorsUrls.ERROR_500_URL)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(ModelMap modelMap) {
        return TEMPLATES_FOLDER + "500";
    }
}