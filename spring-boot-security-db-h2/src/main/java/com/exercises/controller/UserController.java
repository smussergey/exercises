package com.exercises.controller;

import com.exercises.dto.UserRegistrationDTO;
import com.exercises.model.User;
import com.exercises.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/users")
    public String getUsers(Model model) {
        List<User> users =  userService.findAll();
        model.addAttribute("users",users);
        return "users";
    }

    @PostMapping("/admin/user/add")
    public String addNewUser(@ModelAttribute UserRegistrationDTO userRegistrationDTO) {
        userService.registerNewUser(userRegistrationDTO);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}
