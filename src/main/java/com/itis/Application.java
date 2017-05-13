package com.itis;

import com.itis.models.Role;
import com.itis.models.User;
import com.itis.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.EnumSet;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner testData(UserRepository userRepository) {
//        final User user = new User();
//        user.setEmail("test@test.com");
//        user.setFullName("Test User");
//        user.setPassword("password");
//        user.setRoles(EnumSet.of(Role.USER));
//        return args -> userRepository.save(user);
//    }
}
