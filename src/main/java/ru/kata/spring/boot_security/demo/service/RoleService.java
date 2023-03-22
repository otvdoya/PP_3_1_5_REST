package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Collection;

@Service
public interface RoleService {
    void save(Role role);

    Role getById(Long id);

    Collection<Role> findAll();
}
