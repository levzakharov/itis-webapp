package com.itis.transformers;

import com.itis.form.NotificationCreationForm;
import com.itis.model.Notification;
import com.itis.security.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

/**
 * @author alt
 */
@Component
public class NotificationCreationFormToNotificationTransformer
        implements Function<NotificationCreationForm, Notification> {

    @Override
    public Notification apply(
            NotificationCreationForm notificationCreationForm) {
        Notification notification = new Notification();
        notification.setTheme(notificationCreationForm.getTheme());
        notification.setText(notificationCreationForm.getText());
        notification.setDate(new Date().getTime());
        notification.setUser(SecurityUtils.getCurrentUser());
        return notification;
    }
}
