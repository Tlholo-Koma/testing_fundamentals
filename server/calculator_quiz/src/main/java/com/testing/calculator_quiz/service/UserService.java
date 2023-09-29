package com.testing.calculator_quiz.service;

import com.testing.calculator_quiz.controller.CreateUserRequest;
import com.testing.calculator_quiz.entity.User;
import com.testing.calculator_quiz.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUserId(int userId) throws RuntimeException {
        User user = userRepository.getUser(userId);

        if (user == null) {
            throw new RuntimeException("No user found for ID: " + userId);
        }

        return user;
    }

    public User getUserByEmail(CreateUserRequest request) throws RuntimeException {
        User user = userRepository.getUserByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("No user found for email: " + request.getEmail());
        }

        return user;
    }

    @Transactional
    public void createUser(CreateUserRequest request) throws RuntimeException {
        try {
            userRepository.insertUser(request.getEmail(), request.getName());
        } catch (Exception e) {
            throw new RuntimeException("Error setting user for ID: " + e.getMessage());
        }
    }

}