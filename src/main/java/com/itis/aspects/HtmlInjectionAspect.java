package com.itis.aspects;

import com.itis.model.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

/**
 * @author r.khakov
 */
@Aspect
@Component
public class HtmlInjectionAspect {

    @Before("execution(* com.itis.repository.MessageRepository.save(..)) && args(message)")
    public void validMessage(final Message message) throws Exception {
        message.setContent(HtmlUtils.htmlEscape(message.getContent()));
    }

    @Before("execution(* com.itis.repository.NotificationRepository.save(..)) && args(notification)")
    public void validNotification(final Notification notification) throws Exception {
        notification.setText(HtmlUtils.htmlEscape(notification.getText()));
        notification.setTheme(HtmlUtils.htmlEscape(notification.getTheme()));
    }

    @Before("execution(* com.itis.repository.PostRepository.save(..)) && args(post)")
    public void validPost(final Post post) throws Exception {
        post.setText(HtmlUtils.htmlEscape(post.getText()));
        post.setTitle(HtmlUtils.htmlEscape(post.getTitle()));
    }

    @Before("execution(* com.itis.repository.EventRepository.save(..)) && args(event)")
    public void validEvent(final Event event) throws Exception {
        event.setDescription(HtmlUtils.htmlEscape(event.getDescription()));
        event.setName(HtmlUtils.htmlEscape(event.getName()));
        event.setPlace(HtmlUtils.htmlEscape(event.getPlace()));
    }

    @Before("execution(* com.itis.repository.UserRepository.save(..)) && args(user)")
    public void validUser(final User user) throws Exception {
        user.setFullName(HtmlUtils.htmlEscape(user.getFullName()));
        user.setPhone(HtmlUtils.htmlEscape(user.getPhone()));
    }

    @Before("execution(* com.itis.repository.DecreesRepository.save(..)) && args(decree)")
    public void validDecree(final Decree decree) throws Exception {
        decree.setText(HtmlUtils.htmlEscape(decree.getText()));
    }
}