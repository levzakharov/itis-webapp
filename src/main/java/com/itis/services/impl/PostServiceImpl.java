package com.itis.services.impl;

import com.itis.entities.Post;
import com.itis.repositories.PostRepository;
import com.itis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by softi on 01.05.2017.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllOrderByDateDesc() {
        return postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Post getById(long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }
}
