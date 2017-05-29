package com.itis.service;

import com.itis.form.PostCreationForm;
import com.itis.model.Post;

import java.util.List;

/**
 * @author softi on 01.05.2017.
 */
public interface PostService {

    List<Post> getAllOrderByDateDesc();

    Post getById(long id);

    Post update(Post post);

    Post update(Post post, PostCreationForm form);

    void delete(Post post);

    Post create(Post post);

    Post create(PostCreationForm postCreationForm);

}