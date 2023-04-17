package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController()
public class PeopleRestControllers {

    private final UserService userService;

    @Autowired
    public PeopleRestControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/api/current")
    public User getCurrentUser(Principal principal) {
        return userService.findUserByUsername(principal.getName());
    }

    @PostMapping("/api/add")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/api/edit")
    public ResponseEntity<HttpStatus> editUser(@RequestBody User user) {
        userService.editUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/api/delete")
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody User user) {
        userService.deleteUserById(user.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ModelAndView allUsers() {
        return new ModelAndView("usersList");
    }

    @GetMapping("/user")
    public ModelAndView showInfo() {
        return new ModelAndView("userInfo");
    }

}
