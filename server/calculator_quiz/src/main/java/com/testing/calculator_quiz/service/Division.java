package com.testing.calculator_quiz.service;

public class Division extends Operator {

    @Override
    public Double execute(Double value1, Double value2) {
        return value2 / value1;
    }
    
}
