package com.testing.calculator_quiz.service;

import com.testing.calculator_quiz.entity.Score;
import com.testing.calculator_quiz.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getScoreByUserId(int userId) {
        List<Score> scores = scoreRepository.getScore(userId);

        if (scores.isEmpty()) {
            throw new RuntimeException("No scores found for user with ID: " + userId);
        }

        return scores;
    }

    public void setScoreByUserId(int userId, int score) {
        try {
//        scoreRepository.setScore(userId, score);
        } catch (Exception e) {
            throw new RuntimeException("Error setting score for user with ID: " + userId, e);
        }
    }

}