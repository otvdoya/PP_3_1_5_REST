package ru.kata.spring.boot_security.demo.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initFirstUsers() {

        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));

        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(roleService.getById(1L));

        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(roleService.getById(2L));

        Set<Role> rolesUserAndAdmin = new HashSet<>();
        rolesUserAndAdmin.add(roleService.getById(1L));
        rolesUserAndAdmin.add(roleService.getById(2L));

        User simple = new User("user@mail.ru", "user", "user", "user", 25, rolesUser);
        User admin = new User("admin@mail.ru", "admin", "admin", "admin", 28, rolesAdmin);
        User adminUser = new User("adminuser@mail.ru", "admin_user", "admin_user", "admin_user", 21,  rolesUserAndAdmin);

        userService.addUser(simple);
        userService.addUser(admin);
        userService.addUser(adminUser);
    }

}
