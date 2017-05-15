package com.itis.service.impl;

import com.itis.form.PostForm;
import com.itis.model.Post;
import com.itis.repository.PostRepository;
import com.itis.service.PostService;
import com.itis.transformers.PostFormToPostTransformer;
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

    @Autowired
    private PostFormToPostTransformer transformer;


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
    public Post updateByForm(Post post, PostForm postForm) {
        Post post1 = transformer.apply(postForm);
        post1.setId(post.getId());
        return postRepository.save(post1);
    }


    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post createByForm(PostForm postForm) {
        Post post = transformer.apply(postForm);
        return postRepository.save(post);
    }

}