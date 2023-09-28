package com.testing.calculator_quiz.service;

public class Subtration extends Operator {

    @Override
    public Double execute(Double value1, Double value2) {
        Double result = value2 - value1;
        return result;
    }
}
