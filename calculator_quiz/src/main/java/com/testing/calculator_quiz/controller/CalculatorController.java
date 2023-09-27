package com.testing.calculator_quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RestController
// @RequiredArgsConstructor //Used for services
@RequestMapping("/calculator")
public class CalculatorController {
  // Declare services used like:
  // private final CalculatorService calculatorService;
  @GetMapping("/calculation")
  public ResponseEntity<String> resultOfCalculation(@RequestBody String operation) {
    // maybe:
    // return new ResponseEntity<>(calculatorService.calculateThis(operation),
    // HttpStatus.OK);
    return new ResponseEntity<>("Hello there ;-;", HttpStatus.OK);
  }
}
