package com.testing.calculator_quiz.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    private Stack<Double> operands;
    private Stack<Character> operators;
    private Map<Character, Operator> operatorMap;

    public Calculator() {
        operands = new Stack<>();
        operators = new Stack<>();
        operatorMap = new HashMap<>();
        operatorMap.put('+', new Addition());
        operatorMap.put('-', new Subtration());
        operatorMap.put('*', new Multiplication());
        operatorMap.put('/', new Division());
        operatorMap.put('^', new Power());
        operatorMap.put(')', null);
        operatorMap.put('(', null);
    }

    public Double calculate(String expression) throws Exception{
        try {
            String postfix = toPostfix(expression);
            String operand = "";
            Double result, value1, value2;
            for (int i = 0; i < postfix.length(); i++) {
                char exp = postfix.charAt(i);
                if (exp == '$') {
                    operands.push(Double.valueOf(operand));
                    operand = "";
                } else if (exp >= '0' && exp <= '9') {
                    operand += exp;
                } else {
                    value1 = operands.pop();
                    value2 = operands.pop(); 
                    result = operatorMap.get(exp).execute(value1, value2);
                    operands.push(result);
                }
            }
            if (operands.isEmpty() || operands.size() > 1)
                throw new Exception("Invalid expression");
            return operands.pop();  
        } catch (Exception e) {
            // invalid expression
            throw new Exception("Invalid expression");
        }
    }

    private String toPostfix(String expression) throws Exception{
        String postfix = "";
        try {
            for (int i = 0; i < expression.length(); i++) {
                char exp = expression.charAt(i);
                if (i != 0 && operatorMap.containsKey(exp) && !operatorMap.containsKey(postfix.charAt(postfix.length()-1)))
                    postfix += "$";
                
                if (exp >= '0' && exp <= '9') {
                    postfix += exp;
                } else if (exp == '(') {
                    operators.push(exp);
                } else if (exp == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        postfix += operators.pop();
                    }
                    if (!operators.isEmpty()) {
                        operators.pop();
                    }
                }
                else {
                    while (!operators.isEmpty() && operatorPrecedence(operators.peek()) >= operatorPrecedence(exp)) {
                        postfix += operators.pop();
                    }
                    operators.push(exp);
                }
            }
            if (!operatorMap.containsKey(expression.charAt(expression.length()-1)))
                postfix += "$";
            while (!operators.isEmpty())
                postfix += operators.pop();
            return postfix;
        } catch (Exception e) {
            // invalid expression
            throw new Exception("Invalid expression");
        }
        
    }

    private int operatorPrecedence(char op) {
        if (op == '^')
            return 2;
        if (op == '*' || op == '/')
            return 1;
        if (op == '+' || op == '-')
            return 0;
        return -1;
    }
}
