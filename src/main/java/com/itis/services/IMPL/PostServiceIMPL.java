package com.itis.services.IMPL;

import com.itis.entities.Post;
import com.itis.repositories.PostRepository;
import com.itis.services.INTR.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by softi on 01.05.2017.
 */
@Service
@Transactional
public class PostServiceIMPL implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllOrderByDateDesc() {
        return postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Post getById(int id) {
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
}
