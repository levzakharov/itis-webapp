package com.itis.controllers;

import com.itis.services.INTR.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by softi on 01.05.2017.
 */
@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String postIndex(ModelMap modelMap) {
        modelMap.put("posts", postService.getAllOrderByDateDesc());
        return "postindex";
    }
}
