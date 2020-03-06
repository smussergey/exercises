package com.exercises.dto;

import com.exercises.model.Role;
import lombok.Data;

@Data
public class UserRegistrationDTO {
    private Long id;
    private String name;
    private String role;
    private String username;
    private String password;
}
