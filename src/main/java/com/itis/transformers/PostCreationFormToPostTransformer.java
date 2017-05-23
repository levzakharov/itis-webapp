package com.itis.transformers;

import com.itis.form.PostCreationForm;
import com.itis.model.Post;
import com.itis.model.User;
import com.itis.security.SecurityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.function.Function;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Component
public class PostCreationFormToPostTransformer implements Function<PostCreationForm, Post> {

    @Override
    public Post apply(PostCreationForm form) {
        User user = SecurityUtils.getCurrentUser();
        Post post = new Post();
        post.setTitle(form.getTitle());
        post.setText(form.getText().replace("\n", "<br />\n"));
        Long date = new Date().getTime();
        post.setDate(date);
        post.setUser(user);
        return post;
    }
}
