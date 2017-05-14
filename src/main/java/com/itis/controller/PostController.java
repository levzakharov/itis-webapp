package com.itis.controller;

import com.itis.model.Post;
import com.itis.form.PostForm;
import com.itis.model.User;
import com.itis.security.SecurityUtils;
import com.itis.service.PostService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by softi on 01.05.2017.
 */
@Controller
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL, method = RequestMethod.GET)
    public String postIndex(ModelMap modelMap) {
        modelMap.put("posts", postService.getAllOrderByDateDesc());
        return "post/index";
    }

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL + "/new", method = RequestMethod.POST)
    public String postCreate(ModelMap modelMap, @ModelAttribute(name = "post") PostForm postForm) {
        User user = SecurityUtils.getCurrentUser();
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        Long date = new Date().getTime();
        post.setDate(date);
        post.setUser(user);
        postService.create(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL + "/{post_id:\\d+}", method = RequestMethod.GET)
    public String postRead(ModelMap modelMap, @PathVariable long post_id) {
        Post post = postService.getById(post_id);
        modelMap.put("post", post);
        return "post/page";
    }

    @RequestMapping(value = ApplicationUrls.WebAppUrls.BASE_NEWS_URL + "/{post_id:\\d+}", method = RequestMethod.POST)
    public String postUpdate(@ModelAttribute(name = "post") PostForm postForm, @PathVariable long post_id) {
        Post post = postService.getById(post_id);

        if ("update".equals(postForm.getAction())) {
            post.setTitle(postForm.getTitle());
            post.setText(postForm.getText());
            postService.update(post);
        } else if ("delete".equals(postForm.getAction())) {
            postService.delete(post);
        }

        return "redirect:/posts";
    }

    @ApiOperation("List Posts")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> postIndexApi() {
        return postService.getAllOrderByDateDesc();
    }

}
