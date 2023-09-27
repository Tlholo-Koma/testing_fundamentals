package com.testing.calculator_quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import service.Calculator;

import java.util.Map;

import org.springframework.http.HttpStatus;

@RestController
// @RequiredArgsConstructor //Used for services
@RequestMapping("/calculator")
public class CalculatorController {
  // Declare services used like:
  private final Calculator calculator = new Calculator();
  // private final CalculatorService calculatorService;
  @PostMapping("/calculate")
  public ResponseEntity<String> resultOfCalculation(@RequestBody Map<String, String> object) throws Exception {
    // maybe:
    // return new ResponseEntity<>(calculatorService.calculateThis(operation),
    // HttpStatus.OK);
    return new ResponseEntity<String>(calculator.calculate(object.get("expression")).toString(),
                                      HttpStatus.OK);
  }
}
