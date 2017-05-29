package com.itis.service;

import com.itis.model.User;
import com.itis.model.enums.Role;

import java.util.List;

/**
 * @author softi on 25.05.2017.
 */
public interface UserService {

    List<User> getAll();

    List<User> getByRole(Role role);

    User getById(long id);
}