package com.itis.service;

import com.itis.form.NotificationCreationForm;
import com.itis.model.UserGroup;

import java.util.List;

/**
 * @author r.khakov
 */
public interface UserGroupService {

    List<UserGroup> getUserGroupsByCourse(Integer courseNumber);

    List<UserGroup> getUserGroupsFromNotificationCreationForm(
            NotificationCreationForm notificationCreationForm);

    UserGroup getUserGroup(long id);

    Integer getCourseByUserGroups(UserGroup userGroup);

}
