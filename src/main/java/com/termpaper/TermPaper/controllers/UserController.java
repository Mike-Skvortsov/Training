package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public Optional<User> getByIdUser(@PathVariable int id)
    {
        return userService.getUser(id);
    }
    @GetMapping("/all")
    public Iterable<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
}
