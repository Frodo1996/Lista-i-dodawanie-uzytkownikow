package com.example.userslist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public String addNewUser(@RequestParam(name = "imie", required = false) String firstName,
                             @RequestParam(name = "nazwisko", required = false) String lastName,
                             @RequestParam(name = "wiek", required = false) Integer age) {
        if (firstName.equalsIgnoreCase("")) {
            return "redirect:/err.html";
        } else {
            userRepository.addNewUser(firstName, lastName, age);
            return "redirect:/success.html";
        }
    }

    @GetMapping("/users")
    @ResponseBody
    public String printUserList() {
        List<User> allUsers = userRepository.findAllUsers();
        return allUsers.toString();
    }
}