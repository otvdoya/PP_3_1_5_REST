package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String allUsers(Model model, Principal principal) {
        model.addAttribute("thisUser", userService.findUserByUsername(principal.getName()).orElse(null));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("newUser", new User());
        return "usersList";
    }

    @PatchMapping("edit/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.editUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

}
