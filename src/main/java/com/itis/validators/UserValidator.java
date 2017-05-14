package com.itis.validators;

import com.itis.model.User;
import com.itis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator implements org.springframework.validation.Validator {
    private UserRepository repository;

    @Autowired
    public UserValidator(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final User user = (User) target;
        if (user.getId() == null && repository.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "email.taken", "is already taken");
        }
    }
}
