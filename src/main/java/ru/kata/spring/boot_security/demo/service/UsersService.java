package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();

    User findById(int id);

    void saveUser(User user);

    void deleteById(int id);

      User findByUsername(String username);
}

