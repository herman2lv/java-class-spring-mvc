package com.hrm.springmvcdemo.web.controller;

import com.hrm.springmvcdemo.service.UserService;
import com.hrm.springmvcdemo.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        UserDto user = userService.getById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/getAll")
    public String getUsers(Model model) {
        List<UserDto> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/create")
    public String createUserForm() {
        return "createUserForm";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserDto user) {
        userService.create(user);
        return "redirect:/users/" + user.getId();
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        UserDto user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUserForm";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute UserDto user) {
        userService.edit(user);
        return "redirect:/users/" + user.getId();
    }

    @PostMapping("/delete/{id}")
    public String editUserForm(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/getAll";
    }
}
