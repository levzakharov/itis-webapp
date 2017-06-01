package com.itis.transformers;

import com.itis.form.UserParsingForm;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by softi on 31.05.2017.
 */
@Component
public class UserParsingFormToUserTransformer implements Function<UserParsingForm, User> {

    @Autowired
    private UserGroupService userGroupService;

    @Override
    public User apply(UserParsingForm userParsingForm) {
        User user = new User();
        return apply(userParsingForm, user);

    }

    public User apply(UserParsingForm userParsingForm, User user) {
        user.setFullName(userParsingForm.getFullName());
        user.setEmail(userParsingForm.getEmail());
        user.setPhone(userParsingForm.getPhone());
        user.setUserGroup(userGroupService.getUserGroup(userParsingForm.getUserGroup()));
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = dateFormat.parse(userParsingForm.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(date.getTime());
        boolean contract = !userParsingForm.getContract().isEmpty();
        user.setContract(contract);

        List<String> roles = Arrays.asList(userParsingForm.getRoles().split(","));
        for (String role : roles) {
            user.getRoles().add(Role.valueOf(role.toUpperCase()));
        }

        return user;
    }
}
