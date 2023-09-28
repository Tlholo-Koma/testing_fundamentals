package com.testing.calculator_quiz.controller;

import com.testing.calculator_quiz.entity.Score;
import com.testing.calculator_quiz.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;

    ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/{userId}")
    public Score getScoreByUserId(@PathVariable Integer userId) {
        return scoreService.getScoreByUserId(userId);
    }
}
