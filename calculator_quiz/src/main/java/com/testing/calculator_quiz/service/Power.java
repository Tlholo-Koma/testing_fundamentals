package com.testing.calculator_quiz.service;

public class Power extends Operator {

    @Override
    public Double execute(Double value1, Double value2) {
        return Math.pow(value1, value2);
    }
    
}
