package com.itis.service.impl;

import com.itis.form.PostCreationForm;
import com.itis.model.Post;
import com.itis.repository.PostRepository;
import com.itis.service.DocumentService;
import com.itis.service.ImageService;
import com.itis.service.PostService;
import com.itis.storage.StorageService;
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

    private PostRepository postRepository;
    private PostCreationFormToPostTransformer transformer;
    private ImageService imageService;
    private DocumentService documentService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostCreationFormToPostTransformer transformer,
                           ImageService imageService, DocumentService documentService, StorageService storageService) {
        this.postRepository = postRepository;
        this.transformer = transformer;
        this.imageService = imageService;
        this.documentService = documentService;
    }

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
    public Post update(Post post, PostCreationForm form) {
        Post post1 = transformer.apply(form);
        post.setTitle(post1.getTitle());
        post.setText(post1.getText());
        return postRepository.save(post);
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
    public Post create(PostCreationForm postCreationForm) {
        Post post = transformer.apply(postCreationForm);

        if (postCreationForm.getImages() != null && postCreationForm.getImages().get(0).getOriginalFilename().length() > 0) {
            post.setImages(imageService.create(postCreationForm.getImages()));
        }
        if (postCreationForm.getDocuments() != null && postCreationForm.getDocuments().get(0).getOriginalFilename().length() > 0) {
            post.setDocuments(documentService.create(postCreationForm.getDocuments()));
        }
        return postRepository.save(post);
    }
}