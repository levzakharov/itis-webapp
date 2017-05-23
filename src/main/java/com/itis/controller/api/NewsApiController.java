package com.itis.controller.api;

import com.itis.form.PostCreationForm;
import com.itis.model.Post;
import com.itis.service.PostService;
import com.itis.utils.ApplicationUrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;

/**
 * @author softi on 14.05.2017.
 */
@RestController
public class NewsApiController {

    private final PostService postService;

    @Autowired
    public NewsApiController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation("Create Post. This method is expecting an object of class PostCreationForm for validation. There also should be a parametr 'action'")
    @PostMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public ResponseEntity<Post> postCreate(@RequestBody PostCreationForm postCreationForm) {
        return new ResponseEntity<>(postService.createByForm(postCreationForm), HttpStatus.OK);
    }

    @ApiOperation("Get news by id")
    @GetMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL + "/{postId}")
    public ResponseEntity<Post> postRead(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.getById(postId), HttpStatus.OK);
    }

    @ApiOperation("Update Post. This method is expecting an object of class Post for validation")
    @PutMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public ResponseEntity<Post> postUpdate(@RequestBody Post post) {
        return new ResponseEntity<>(postService.update(post), HttpStatus.OK);
    }

    @ApiOperation("Delete Post. This method is expecting an object of class Post for validation")
    @DeleteMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public ResponseEntity postDelete(@RequestBody Post post) {
        postService.delete(post);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("List Posts")
    @GetMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public List<Post> postIndex() {
        return postService.getAllOrderByDateDesc();
    }
}