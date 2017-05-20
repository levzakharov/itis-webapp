package com.itis.controller;

import com.itis.model.Image;
import com.itis.model.Post;
import com.itis.form.PostForm;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.security.SecurityUtils;
import com.itis.service.ImageService;
import com.itis.service.PostService;
import com.itis.storage.StorageService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 01.05.2017.
 */
@Controller
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    StorageService storageService;

    @Autowired
    ImageService imageService;

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL, method = RequestMethod.GET)

    public String getPostsPage(ModelMap modelMap) {
        modelMap.put("posts", postService.getAllOrderByDateDesc());
        return "post/index";
    }

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL + "/new", method = RequestMethod.POST)
    public String createPost(@ModelAttribute(name = "post") PostForm postForm) {
        postService.createByForm(postForm);
        return "redirect:/news";
    }

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL + "/update/{post_id:\\d+}", method = RequestMethod.POST)
    public String updatePost(@ModelAttribute(name = "post") PostForm postForm, @PathVariable long post_id) {
        Post post = postService.getById(post_id);
        postService.updateByForm(post, postForm);
        return "redirect:/news";
    }

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL + "/delete/{post_id:\\d+}", method = RequestMethod.POST)
    public String deletePost(@ModelAttribute(name = "post") PostForm postForm, @PathVariable long post_id) {
        Post post = postService.getById(post_id);
        postService.delete(post);
        return "redirect:/news";

    }



}
