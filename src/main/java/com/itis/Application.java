package com.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
