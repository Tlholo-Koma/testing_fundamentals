package com.testing.calculator_quiz.controller;

import com.testing.calculator_quiz.entity.Score;
import com.testing.calculator_quiz.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ScoreController {
    private final ScoreService scoreService;

    ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/user/{userId}/score")
    public ResponseEntity<List<Score>> getScoreByUserId(@PathVariable Integer userId) {
        try {
            List<Score> scores = scoreService.getScoreByUserId(userId);
            return ResponseEntity.ok(scores);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/user/{userId}/score")
    public ResponseEntity<String> setScoreByUserId(@PathVariable Integer userId, @RequestBody Map<String, Integer> requestBody) {
        Integer score = requestBody.get("score");
         scoreService.setScoreByUserId(userId, score);
        return ResponseEntity.ok("Score added successfully!");
    }
}
