package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void deleteUserById(long id);

    void editUser(User user);

    Optional<User> findUserByUsername(String username);
}
