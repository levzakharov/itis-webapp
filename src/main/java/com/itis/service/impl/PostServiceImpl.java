package com.itis.service.impl;

import com.itis.form.PostCreationForm;
import com.itis.model.Post;
import com.itis.repository.PostRepository;
import com.itis.service.PostService;
import com.itis.transformers.PostCreationFormToPostTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author softi on 01.05.2017.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCreationFormToPostTransformer transformer;


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
    public Post updateByForm(Post post, PostCreationForm form) {
        Post post1 = transformer.apply(form);
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
    public Post createByForm(PostCreationForm postCreationForm) {
        Post post = transformer.apply(postCreationForm);
        return postRepository.save(post);
    }

}
