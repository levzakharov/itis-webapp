package com.itis.controller.api;

import com.itis.form.PostForm;
import com.itis.model.Post;
import com.itis.service.PostService;
import com.itis.utils.ApplicationUrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * Created by softi on 14.05.2017.
 */
@RestController
public class PostApiController {

    private final PostService postService;

    @Autowired
    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation("Create Post. This method is expecting an object of class PostForm for validation. There also should be a parametr 'action'")
    @PostMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public ResponseEntity<Post> createPost(@RequestBody PostForm postForm) {
        return new ResponseEntity<>(postService.createByForm(postForm), HttpStatus.OK);
    }

    @ApiOperation("Get post by id")
    @GetMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL + "/{postId}")
    public ResponseEntity<Post> getPostPage(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.getById(postId), HttpStatus.OK);
    }

    @ApiOperation("Update Post. This method is expecting an object of class Post for validation")
    @PutMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.update(post), HttpStatus.OK);
    }

    @ApiOperation("Delete Post. This method is expecting an object of class Post for validation")
    @DeleteMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL)
    public ResponseEntity deletePost(@RequestBody Post post) {
        postService.delete(post);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("List Posts")
    @RequestMapping(value = ApplicationUrls.ApiUrls.BASE_NEWS_URL, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> postIndexApi() {
        return postService.getAllOrderByDateDesc();
    }
}