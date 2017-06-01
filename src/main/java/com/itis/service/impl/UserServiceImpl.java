package com.itis.service.impl;

import com.itis.exceptions.TimetableCreationException;
import com.itis.form.UserParsingForm;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.repository.UserRepository;
import com.itis.service.UserService;
import com.itis.transformers.UserParsingFormToUserTransformer;
import com.itis.utils.CSVParser;
import com.itis.utils.CSVWriter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author softi on 25.05.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserParsingFormToUserTransformer transformer;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserParsingFormToUserTransformer transformer) {
        this.userRepository = userRepository;
        this.transformer = transformer;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    private static final Logger LOGGER = Logger.getLogger(EventServiceImpl.class);

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
    public void createUsers(MultipartFile file) {
        try {
            if (!CSVParser.CSVFormats.contains(file.getContentType())) {
                throw new IllegalArgumentException("incorrect format of csv file");
            }
            Set<UserParsingForm> userParsingForms = CSVParser.parse(file.getBytes(), UserParsingForm.class);
            assert userParsingForms != null;
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userParsingForms.forEach(userParsingForm -> {
                User user = userRepository.findByEmail(userParsingForm.getEmail());
                if (user == null) {
                    user = transformer.apply(userParsingForm);
                } else {
                    user = transformer.apply(userParsingForm, user);
                }
                String password = (UUID.randomUUID().toString()).substring(0, 8);
                user.setPassword(password);
                CSVWriter.writeToCSV(user);
                userRepository.save(user);
            });
        } catch (IOException e) {
            LOGGER.error("error occured while parsing csv file to timetable events : ", e);
            throw new TimetableCreationException();
        }
    }

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