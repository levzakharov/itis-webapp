package com.itis.controller;

import com.itis.form.PostForm;
import com.itis.model.Post;
import com.itis.service.PostService;
import com.itis.utils.ApplicationUrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

/**
 * @author softi on 01.05.2017.
 */
@Controller
public class NewsController {

    private final PostService postService;

    @Autowired
    public NewsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(ApplicationUrls.WebAppUrls.BASE_NEWS_URL)
    public String postIndex(Model model) {
        model.addAttribute("posts", postService.getAllOrderByDateDesc());
        return "news/index";
    }

    @PostMapping(ApplicationUrls.WebAppUrls.BASE_NEWS_URL)
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN')")
    public String postCreate(@ModelAttribute(name = "post") PostForm postForm) {
        postService.createByForm(postForm);
        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.NEW)
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN')")
    public String postUpdate(@ModelAttribute(name = "post") PostForm postForm, @PathVariable("newId") Long newId) {
        Post post = postService.getById(newId);
        if ("update".equals(postForm.getAction())) {
            postService.updateByForm(post, postForm);
        } else if ("delete".equals(postForm.getAction())) {
            postService.delete(post);
        }

        return "redirect:" + ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
    }

}
