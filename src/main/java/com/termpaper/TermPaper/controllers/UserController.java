package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public Optional<User> getByIdUser(@PathVariable int id)
    {
        return userService.getUser(id);
    }
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User model) {
        User createdUser = userService.createAndUpdateUser(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User userDetails) {
        Optional<User> optionalUser = userService.getUser(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setGender(userDetails.getGender());
            user.setAge(userDetails.getAge());
            user.setHeight(userDetails.getHeight());
            user.setWeight(userDetails.getWeight());
            userService.createAndUpdateUser(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        Optional<User> optionalUser = userService.getUser(id);
        if (optionalUser.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
