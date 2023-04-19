package com.example.zad_lista_i_dodawania_uzytkownikow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
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
    @RequestMapping("/users")
    @ResponseBody
    public String printUserList() {
        return userRepository.printAllUsers();
    }
}