package com.itis.service.impl;

import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.repository.UserRepository;
import com.itis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author softi on 25.05.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByRole(Role role) {
        List<User> users = getAll();
        List<User> teachers = new ArrayList<>();
        for (User user : users) {
            if (user.getRoles().contains(role)) {
                teachers.add(user);
            }
        }
        return teachers;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsersExceptingAdmin() {
        return userRepository.findAllNotContainingRole(Role.ADMIN);
    }

    @Transactional
    @Override
    public void ban(long id) {
        userRepository.ban(id);
    }

    @Transactional
    @Override
    public void unban(long id) {
        userRepository.unban(id);
    }

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }
}