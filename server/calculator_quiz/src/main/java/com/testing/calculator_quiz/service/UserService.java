package com.testing.calculator_quiz.service;

import com.testing.calculator_quiz.entity.Score;
import com.testing.calculator_quiz.entity.User;
import com.testing.calculator_quiz.repository.ScoreRepository;
import com.testing.calculator_quiz.repository.UserRepository;
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

    public void setUserByUserId(int userId, String email) throws RuntimeException {
        try {
//            userRepository.setUser(userId, email);
        } catch (Exception e) {
            throw new RuntimeException("Error setting user for ID: " + userId, e);
        }
    }

}