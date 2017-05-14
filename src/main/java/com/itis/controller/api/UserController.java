package com.itis.controller.api;

import com.itis.model.User;
import com.itis.repository.UserRepository;
import com.itis.utils.ApplicationUrls;
import com.itis.utils.CSVParser;
import com.itis.validators.UserValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation("save user")
    @PostMapping(ApplicationUrls.ApiUrls.BASE_USERS_URL)
    public ResponseEntity save(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        } else {
            return ResponseEntity
                    .status(user.getId() == null ? HttpStatus.CREATED : HttpStatus.OK)
                    .body(repository.save(user));
        }
    }

    @ApiOperation("import users")
    @PostMapping(ApplicationUrls.ApiUrls.IMPORT_USERS_URL)
    public ResponseEntity importUsers(@RequestParam MultipartFile file) throws IOException {
        final Set<User> users = CSVParser.parse(file.getBytes(), User.class);
        if (users == null) {
            return ResponseEntity.badRequest().body("Parsing failure");
        }
        final Set<FieldError> errors = validator.validate(users);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(users));
    }

    @ApiOperation("find user")
    @GetMapping(ApplicationUrls.ApiUrls.FIND_USER_URL)
    public User find(@RequestParam String email) {
        return repository.findByEmail(email);
    }

    @ApiOperation("delete user")
    @DeleteMapping(ApplicationUrls.ApiUrls.USER_URL)
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            repository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("User with id '" + id + "' does not exist");
        }
        return ResponseEntity.noContent().build();
    }
}