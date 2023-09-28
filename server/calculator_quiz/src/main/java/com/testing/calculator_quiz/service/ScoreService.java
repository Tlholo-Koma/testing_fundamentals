package com.testing.calculator_quiz.service;

import com.testing.calculator_quiz.entity.Score;
import com.testing.calculator_quiz.repository.ScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public Score getScoreByUserId(int userId) {
        return scoreRepository.getScore(userId);
    }

    public void setScoreByUserId(int userId, int score) {
//        scoreRepository.setScore(userId, score);
    }

}