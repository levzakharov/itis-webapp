package com.itis;

import com.itis.model.enums.Role;
import com.itis.model.User;
import com.itis.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.EnumSet;

import static java.util.Objects.isNull;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner testData(UserRepository userRepository) {
        if (isNull(userRepository.findByEmail("test@test.com"))) {
            final User user = new User();
            user.setEmail("test@test.com");
            user.setFullName("Test User");
            user.setPassword("password");
            user.setRoles(EnumSet.of(Role.USER));
            return args -> userRepository.save(user);
        }
        return null;
    }
}
