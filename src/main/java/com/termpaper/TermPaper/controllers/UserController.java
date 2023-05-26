package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.userDTO.UserDTOWithoutIdAndHistories;
import com.termpaper.TermPaper.mappers.UserMapper;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private final UserService userService;
    private final UserMapper userMapper;
    public UserController(UserService userService, UserMapper userMapper)
    {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTOWithoutIdAndHistories> getByIdUser(@PathVariable int id)
    {
        User user = userService.getUser(id)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("Training with this id does not exist: " + id));
        return ResponseEntity.ok(userMapper.toUserDTOWithoutIdAndHistories(user));
    }
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody @Valid User model) {
        return new ResponseEntity<>(userService.createUser(model), HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        boolean isDeleted = userService.deleteUserById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
