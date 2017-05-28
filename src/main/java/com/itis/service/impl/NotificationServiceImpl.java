package com.itis.service.impl;

import com.itis.form.NotificationCreationForm;
import com.itis.model.Notification;
import com.itis.model.User;
import com.itis.model.UserGroup;
import com.itis.model.enums.Role;
import com.itis.repository.NotificationRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.NotificationService;
import com.itis.service.UserGroupService;
import com.itis.service.UserNotificationService;
import com.itis.transformers.NotificationCreationFormToNotificationTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alt
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationCreationFormToNotificationTransformer creationFormToNotificationTransformer;
    private final UserNotificationService userNotificationService;
    private final UserGroupService userGroupService;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   NotificationCreationFormToNotificationTransformer transformer,
                                   UserNotificationService userNotificationService,
                                   UserGroupService userGroupService) {
        this.notificationRepository = notificationRepository;
        this.creationFormToNotificationTransformer = transformer;
        this.userNotificationService = userNotificationService;
        this.userGroupService = userGroupService;
    }

    @Override
    public Notification getOne(Long id) {
        return notificationRepository.findOne(id);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(Notification notification) {
        notificationRepository.delete(notification);
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getCurrentUserSentNotifications() {
        return this.getSentNotificationsByUser(SecurityUtils.getCurrentUser());
    }

    @Override
    public List<Notification> getSentNotificationsByUser(User user) {
        return notificationRepository.findByUserOrderByDateDesc(user);
    }

    @Override
    public Notification sendNotification(NotificationCreationForm notificationCreationForm) {

        User currentUser = SecurityUtils.getCurrentUser();

        Notification notification = creationFormToNotificationTransformer.apply(notificationCreationForm);

        if (currentUser.getRoles().contains(Role.STAROSTA)) {
            this.create(notification);

            userNotificationService.createUserNotificationsByGroup(notification, currentUser.getUserGroup());
        } else {
            if (notificationCreationForm.getGroups() != null) {
                List<UserGroup> userGroups =
                        userGroupService.getUserGroupsFromNotificationCreationForm(notificationCreationForm);
                this.create(notification);
                userNotificationService.createUserNotificationsByGroups(notification, userGroups);
            } else {
                return null;
            }
        }
        return notification;
    }
}