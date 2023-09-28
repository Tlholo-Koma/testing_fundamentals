package com.testing.calculator_quiz.controller;

import com.testing.calculator_quiz.entity.User;
import com.testing.calculator_quiz.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable Integer userId) {
        return userService.getUserByUserId(userId);
    }

    @PostMapping("/set/{userId}")
    public void setUserByUserId(@PathVariable Integer userId, @RequestBody Integer score) {
        userService.setUserByUserId(userId, score);
    }
}
