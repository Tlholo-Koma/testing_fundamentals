package com.testing.calculator_quiz.service;

public class Addition extends Operator {

    @Override
    public Double execute(Double value1, Double value2) {
        return value1 + value2;
    }
    
}
