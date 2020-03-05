package com.exercises;

import com.exercises.model.Role;
import com.exercises.model.User;
import com.exercises.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class SpringBootSecurityDbHaApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDbHaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = User.builder()
                .name("Sergey")
                .username("us")
                .password(bCryptPasswordEncoder.encode("uspas"))
                .role(Role.ROLE_ADMIN)
                .build();

        userService.saveUser(user);
    }
}
