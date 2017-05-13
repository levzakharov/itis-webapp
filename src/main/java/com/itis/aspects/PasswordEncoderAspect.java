package com.itis.aspects;

import com.itis.models.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PasswordEncoderAspect {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordEncoderAspect(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Before("execution(* com.itis.repositories.UserRepository.save(..)) && args(user)")
    public void encodePassword(final User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
