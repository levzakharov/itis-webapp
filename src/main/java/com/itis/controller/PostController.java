package com.itis.controller;

import com.itis.model.Image;
import com.itis.form.PostCreationForm;
import com.itis.model.Post;
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

    @PostMapping(value = ApplicationUrls.WebAppUrls.CREATE_NEWS_URL)
    public String createPost(@ModelAttribute PostCreationForm postCreationForm) {
        postService.createByForm(postCreationForm);
        return "redirect:/news";
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.UPDATE_NEWS_URL)
    public String updatePost(@ModelAttribute(name = "post") PostCreationForm postCreationForm, @PathVariable long postId) {
        Post post = postService.getById(postId);
        postService.updateByForm(post, postCreationForm);
        return "redirect:/news";
    }

    @PostMapping(value = ApplicationUrls.WebAppUrls.DELETE_NEWS_URL)
    public String deletePost(@PathVariable long postId) {
        Post post = postService.getById(postId);
        postService.delete(post);
        return "redirect:/news";
    }



}
