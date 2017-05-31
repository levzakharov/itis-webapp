package com.itis.controller.handlers;

import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.utils.ApplicationUrls;
import netscape.security.ForbiddenTargetException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by softi on 30.05.2017.
 */
@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public ModelAndView handleMultipartException(HttpServletRequest req, MultipartException ex, RedirectAttributes redirectAttributes) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);


        String uri = req.getRequestURI();
        String reditectUrl = "redirect:" + ApplicationUrls.WebAppErrorsUrls.ERROR_500_URL;
        if (uri.contains("news")) {
            reditectUrl = "redirect:" + ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
        } else if (uri.contains("documents")) {
            User user = SecurityUtils.getCurrentUser();
            if (user.getRoles().contains(Role.ADMIN) || user.getRoles().contains(Role.WORKER)) {
                reditectUrl = "redirect:" + ApplicationUrls.WebAppUrls.DEAN_DOCUMENTS_URL;
            } else {
                reditectUrl = "redirect:" + ApplicationUrls.WebAppUrls.TEACHER_FOLDERS_URL + "/" + user.getId();
            }
        }

        ModelAndView mav = new ModelAndView(reditectUrl);
        String message = "Размер файла не должен превышать 100 MB";
        redirectAttributes.addFlashAttribute("error", message);
        return mav;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalException(HttpServletRequest req, Exception ex, RedirectAttributes redirectAttributes) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);


        String reditectUrl = "redirect:" + ApplicationUrls.WebAppErrorsUrls.ERROR_500_URL;
        if (ex.getMessage().toLowerCase().contains("eventparsingform")) {
            reditectUrl = "redirect:" + ApplicationUrls.WebAppUrls.BASE_TIMETABLE_URL;
            redirectAttributes.addFlashAttribute("error", "Некорректный формат csv");
        } else if (ex.getMessage().toLowerCase().contains("csv file")) {
            reditectUrl = "redirect:" + ApplicationUrls.WebAppUrls.BASE_TIMETABLE_URL;
            redirectAttributes.addFlashAttribute("error", "Некорректное расширение файла csv");
        } else if (ex.getMessage().toLowerCase().contains("image")) {
            reditectUrl = "redirect:" + ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
            redirectAttributes.addFlashAttribute("error", "Некорректное расширение изображения");
        } else {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        ModelAndView mav = new ModelAndView(reditectUrl);

        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest req, Exception ex, RedirectAttributes redirectAttributes) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);


        String reditectUrl = "redirect:" + ApplicationUrls.WebAppErrorsUrls.ERROR_500_URL;

        ModelAndView mav = new ModelAndView(reditectUrl);
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return mav;
    }
}
