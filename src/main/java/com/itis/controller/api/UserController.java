package com.itis.controller.api;

import com.itis.model.User;
import com.itis.repository.UserRepository;
import com.itis.utils.ApplicationUrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import static java.util.Collections.singletonMap;

@Controller
@RequestMapping(ApplicationUrls.ApiUrls.BASE_USERS_URL)
public class UserController {
    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("create user")
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody User user, BindingResult result) {
        if (repository.findByEmail(user.getEmail()) != null) {
            result.rejectValue("email", "email.taken", "is already taken");
        }
        if (result.hasErrors()) {
            final Map<String, List<FieldError>> errors = new HashMap<>();
            result.getFieldErrors().forEach((error) -> {
                errors.putIfAbsent(error.getField(), new ArrayList<>());
                errors.get(error.getField()).add(error);
            });
            return ResponseEntity.badRequest()
                    .body(singletonMap("errors", errors));
        } else {
            repository.save(user);
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }
}