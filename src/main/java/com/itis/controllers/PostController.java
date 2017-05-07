package com.itis.controllers;

import com.itis.entities.Post;
import com.itis.forms.PostForm;
import com.itis.services.INTR.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by softi on 01.05.2017.
 */
@Controller
@EnableAutoConfiguration
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String postIndex(ModelMap modelMap) {
        modelMap.put("posts", postService.getAllOrderByDateDesc());
        return "postindex";
    }


    @RequestMapping(value = "/posts/new", method = RequestMethod.GET)
    public String addPostPage() {
        return "postadd";
    }

    @RequestMapping(value = "/posts/new", method = RequestMethod.POST)
    public String addPost(ModelMap modelMap, @ModelAttribute(name = "post") PostForm postForm) {
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        Date date = new Date();
        post.setDate(date);
        postService.add(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts/{post_id:\\d+}", method = RequestMethod.GET)
    public String postPage(ModelMap modelMap, @PathVariable int id) {
        Post post = postService.getById(id);
        modelMap.put("post", post);
        return "postpage";
    }

    @RequestMapping(value = "/posts/{post_id:\\d+}", method = RequestMethod.POST)
    public String postUpdate(@ModelAttribute(name = "post") PostForm postForm, @PathVariable int id) {
        Post post = postService.getById(id);
        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        return "redirect:/posts";
    }


}
