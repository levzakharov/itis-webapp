package com.itis.service;

import com.itis.model.Post;

import java.util.List;

/**
 * Created by softi on 01.05.2017.
 */
public interface PostService {

    List<Post> getAllOrderByDateDesc();

    Post getById(long id);

    Post update(Post post);

    void delete(Post post);

    Post add(Post post);
}
