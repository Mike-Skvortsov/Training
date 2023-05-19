package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @GetMapping("/id")
    public User getUser(@RequestParam int id)
    {
        return userService.getUser(id);
    }
    @GetMapping("/all")
    public Iterable<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
}
