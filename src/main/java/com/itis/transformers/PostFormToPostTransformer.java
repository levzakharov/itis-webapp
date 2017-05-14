package com.itis.transformers;

import com.itis.form.EventCreationForm;
import com.itis.form.PostForm;
import com.itis.model.Event;
import com.itis.model.Post;
import com.itis.model.User;
import com.itis.security.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Component
public class PostFormToPostTransformer implements Function<PostForm, Post> {

    @Override
    public Post apply(PostForm postForm) {
        User user = SecurityUtils.getCurrentUser();
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        Long date = new Date().getTime();
        post.setDate(date);
        post.setUser(user);
        return post;
    }
}
