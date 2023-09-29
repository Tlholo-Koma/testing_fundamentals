package com.testing.calculator_quiz.controller;

import com.testing.calculator_quiz.entity.User;
import com.testing.calculator_quiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable Integer userId) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/user")
    public User getUserByEmail(@RequestBody CreateUserRequest request) {
        return userService.getUserByEmail(request);
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUserByEmail(@RequestBody CreateUserRequest request) {
        try {
            userService.createUser(request);
            return ResponseEntity.ok("User created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user: " + e.getMessage());
        }
    }
}
