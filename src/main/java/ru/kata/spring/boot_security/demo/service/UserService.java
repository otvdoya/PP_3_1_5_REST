package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void deleteUserById(long id);

    void editUser(User user);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User findUserByUsername(String username);
}
