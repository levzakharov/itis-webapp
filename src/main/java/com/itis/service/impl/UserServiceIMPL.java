package com.itis.service.impl;

import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.repository.UserRepository;
import com.itis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 25.05.2017.
 */
@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByRole(Role role) {
        List<User> users = getAll();
        List<User> teachers = new ArrayList<>();
        for (User user : users){
            if (user.getRoles().contains(role)) {
                teachers.add(user);
            }
        }
        return teachers;
    }
}
