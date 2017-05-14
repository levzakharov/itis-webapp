package com.itis.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itis.model.User;
import com.itis.repository.UserRepository;
import com.itis.utils.ApplicationUrls;
import com.itis.validators.UserValidator;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(ApplicationUrls.ApiUrls.BASE_USERS_URL)
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
    @PostMapping
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
    @PostMapping("import")
    public ResponseEntity importUsers(@RequestParam MultipartFile file) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Iterator<CSVRecord> iterator = CSVParser.parse(new String(file.getBytes()), CSVFormat.DEFAULT).iterator();
        if (!iterator.hasNext()) {
            return ResponseEntity.badRequest().body("Parsing failure");
        }
        final CSVRecord headers = iterator.next();
        final Set<User> users = new HashSet<>();
        final Set<FieldError> errors = new HashSet<>();
        iterator.forEachRemaining((record) -> {
            final Map<String, String> values = new HashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                values.put(headers.get(i), record.get(i));
            }
            final User user = objectMapper.convertValue(values, User.class);
            final BeanPropertyBindingResult result = new BeanPropertyBindingResult(user, "user");
            validator.validate(user, result);
            if (result.hasErrors()) {
                errors.addAll(result.getFieldErrors());
            }
            users.add(user);
        });
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(users));
    }

    @ApiOperation("find user")
    @GetMapping("search")
    public User find(@RequestParam String email) {
        return repository.findByEmail(email);
    }

    @ApiOperation("delete user")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            repository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("User with id '" + id + "' does not exist");
        }
        return ResponseEntity.noContent().build();
    }
}