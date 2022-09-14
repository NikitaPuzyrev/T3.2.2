package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
@Service
public interface UsersService {
    List<User> getAllUsers();

    User findById(int id);

    void saveUser(User user);

    void deleteById(int id);

      User findByUsername(String username);
}

