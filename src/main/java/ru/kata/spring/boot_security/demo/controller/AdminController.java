package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @GetMapping("/user")
    public String findAllUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/userCreate")
    public String createUserForm(User user) {
        return "userCreate";
    }

    @PostMapping("userCreate")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("userDelete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("userUpdate/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/newUser")
    public String newUser(User user) {
        return "newUser";
    }
    @PostMapping("newUser")
    public String newUserUpdate(User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<User> getOne(int id)
    {
        return userService.getOne(id);
    }
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        userService.deleteById(id);
        return "redirect:/user";
    }

}
