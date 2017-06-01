package com.itis.aspects;

import com.itis.model.User;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PasswordEncoderAspect {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordEncoderAspect(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Before("execution(* com.itis.repository.UserRepository.save(..)) && args(user)")
    public void encodePassword(final User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Before("execution(* com.itis.repository.UserRepository.save(..)) && args(users)")
    public void encodePassword(final List<User> users) {
        users.forEach(user -> user.setPassword(passwordEncoder.encode(user.getPassword())));
    }
}