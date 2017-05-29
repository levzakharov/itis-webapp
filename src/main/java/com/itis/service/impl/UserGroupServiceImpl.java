package com.itis.service.impl;

import com.itis.form.NotificationCreationForm;
import com.itis.model.UserGroup;
import com.itis.repository.UserGroupRepository;
import com.itis.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author r.khakov
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {

    private final UserGroupRepository userGroupRepository;

    @Autowired
    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public List<UserGroup> getUserGroupsByCourse(Integer courseNumber) {
        Calendar currentDate = Calendar.getInstance();
        int currentMonth = currentDate.get(Calendar.MONTH);
        int groupsStartYear = currentDate.get(Calendar.YEAR) - courseNumber;
        if (currentMonth > 8) {
            groupsStartYear++;
        }
        return userGroupRepository.findByStartYear(groupsStartYear);
    }

    @Override
    public List<UserGroup> getUserGroupsFromNotificationCreationForm(
            NotificationCreationForm notificationCreationForm) {
        List<UserGroup> userGroups = new ArrayList<>();
        for (String groupId : notificationCreationForm.getGroups()) {
            userGroups.add(userGroupRepository.findOne(Long.valueOf(groupId)));
        }
        return userGroups;
    }

    public UserGroup getUserGroup(long id) {
        return userGroupRepository.findOne(id);
    }

    @Override
    public UserGroup getUserGroup(String number) {
        return userGroupRepository.findByNumber(number);
    }

    public Integer getCourseByUserGroups(UserGroup userGroup) {
        Calendar currentDate = Calendar.getInstance();
        int currentMonth = currentDate.get(Calendar.MONTH);
        int groupsStartYear = userGroup.getStartYear();
        if (currentMonth > 8) {
            groupsStartYear--;
        }
        return currentDate.get(Calendar.YEAR) - groupsStartYear;
    }
}
