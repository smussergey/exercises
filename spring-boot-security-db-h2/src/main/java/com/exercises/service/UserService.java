package com.exercises.service;

import com.exercises.dto.UserRegistrationDTO;
import com.exercises.model.Role;
import com.exercises.model.User;
import com.exercises.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User registerNewUser(UserRegistrationDTO userRegistrationDTO) {
        User user = User.builder()
                .name(userRegistrationDTO.getName())
                .role(Role.valueOf(userRegistrationDTO.getRole()))
                .password((bCryptPasswordEncoder.encode(userRegistrationDTO.getPassword())))
                .username(userRegistrationDTO.getUsername())
                .build();

        return saveUser(user);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
