package com.testing.calculator_quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/quiz")
public class QuizController {
  @PostMapping("/result")
  public ResponseEntity<String> resultOfQuiz(@PathVariable Integer resultOutOfTen) {
    return new ResponseEntity<>("Saved (not really)", HttpStatus.OK);
  }
}
