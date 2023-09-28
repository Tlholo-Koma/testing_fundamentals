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

    public User getUserByUserId(int userId) {
        return userRepository.getUser(userId);
    }

    public void setUserByUserId(int userId, String email) {
//        userRepository.setUser(userId, email);
    }

}