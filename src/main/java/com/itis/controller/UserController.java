package com.itis.controller;

import com.itis.model.User;
import com.itis.repository.UserRepository;
import com.itis.utils.ApplicationUrls;
import com.itis.utils.CSVParser;
import com.itis.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;

@Controller
public class UserController {
    private final UserRepository repository;
    private final UserValidator validator;

    @Autowired
    public UserController(UserRepository repository, UserValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @PostMapping(ApplicationUrls.ApiUrls.BASE_USERS_URL)
    public void save(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            // TODO: Render validation errors
        } else {
            repository.save(user);
            // TODO: Render new user
        }
    }

    @PostMapping(ApplicationUrls.ApiUrls.IMPORT_USERS_URL)
    public void importUsers(@RequestParam MultipartFile file) throws IOException {
        final Set<User> users = CSVParser.parse(file.getBytes(), User.class);
        if (users == null) {
            // TODO: Render parsing error
        }
        final Set<FieldError> errors = validator.validate(users);
        if (!errors.isEmpty()) {
            // TODO: Render validation errors
        }
        repository.save(users);
        // TODO: Render saved user
    }

    @GetMapping(ApplicationUrls.ApiUrls.FIND_USER_URL)
    public void find(@RequestParam String email) {
        final User user = repository.findByEmail(email);
        // TODO: Render user
    }

    @GetMapping(ApplicationUrls.ApiUrls.BASE_USERS_URL)
    public void getAll(Pageable pageable) {
        final Page<User> users = repository.findAll(pageable);
        // TODO: Render users
    }

    @DeleteMapping(ApplicationUrls.ApiUrls.USER_URL)
    public void delete(@PathVariable Long id) {
        try {
            repository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            // TODO: Render user absence error
        }
        // TODO: Update users on client
    }
}