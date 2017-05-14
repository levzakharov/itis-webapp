package com.itis.controller.api;

import com.itis.form.PostForm;
import com.itis.model.Post;
import com.itis.service.PostService;
import com.itis.utils.ApplicationUrls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by softi on 14.05.2017.
 */
@Controller
public class PostApiController {
    @Autowired
    PostService postService;

    @ApiOperation("Create Post. This method is expecting an object of class PostForm for validation. There also should be" +
            "a parametr 'action'")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL + "/new", method = RequestMethod.POST)
    @ResponseBody
    public Post postCreate(@RequestBody PostForm postForm) {
        return postService.createByForm(postForm);
    }

    @ApiOperation("Get post by id")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL + "/{post_id:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Post postRead(@PathVariable long post_id) {
        return postService.getById(post_id);
    }

    @ApiOperation("Update Post. This method is expecting an object of class Post for validation")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL , method = RequestMethod.PUT)
    @ResponseBody
    public Post postUpdate(@RequestBody Post post) {
        return postService.update(post);
    }

    @ApiOperation("Delete Post. This method is expecting an object of class Post for validation")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL, method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean postDelete(@RequestBody Post post) {
        postService.delete(post);
        return true;
    }
}
