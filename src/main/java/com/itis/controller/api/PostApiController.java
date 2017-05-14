package com.itis.controller.api;

import com.itis.form.PostForm;
import com.itis.model.Post;
import com.itis.model.User;
import com.itis.security.SecurityUtils;
import com.itis.service.PostService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by softi on 14.05.2017.
 */
@Controller
public class PostApiController {
    @Autowired
    PostService postService;

    @ApiOperation("Create Post. This method is expecting an object of class PostForm for validation. There also should be" +
            "a parametr 'action'")
    @PostMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL + "/new")
    public String postCreateApi(@RequestBody PostForm postForm) {
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

    @ApiOperation("Get post by id")
    @GetMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL + "/{post_id:\\d+}")
    @ResponseBody
    public Post postReadApi(@PathVariable long post_id) {
        return postService.getById(post_id);
    }

    @ApiOperation("Update Post. This method is expecting an object of class Post for validation")
    @PostMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public String postUpdateApi(@RequestBody Post post) {
        postService.update(post);
        return "redirect:/posts";
    }


    @ApiOperation("Update Post. This method is expecting an object of class Post for validation")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL, method = RequestMethod.DELETE)
    public String postDeleteApi(@RequestBody Post post) {
        postService.delete(post);
        return "redirect:/posts";
    }
}
