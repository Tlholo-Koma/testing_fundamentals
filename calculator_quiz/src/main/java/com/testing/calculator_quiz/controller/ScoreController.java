package com.testing.calculator_quiz.controller;

import com.testing.calculator_quiz.entity.Score;
import com.testing.calculator_quiz.service.ScoreService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/set/{userId}")
    public void setScoreByUserId(@PathVariable Integer userId, @RequestBody Integer score) {
        scoreService.setScoreByUserId(userId, score);
    }
}
