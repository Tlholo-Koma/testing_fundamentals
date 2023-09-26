package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
                } else if (exp >= '0' && exp <= '9') {
                    postfix += exp;
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
            // TODO: handle exception
            // invalid expression
            throw new Exception("Invalid expression");
        }
    }

    private String toPostfix(String expression) throws Exception{
        String postfix = "";
        try {
            for (int i = 0; i < expression.length(); i++) {
                char exp = expression.charAt(i);
                if (i != 0 && operatorMap.containsKey(exp))
                    postfix += "$";
                
                if (exp >= '0' && exp <= '9') {
                    postfix += exp;
                } else if (exp == '(') {
                    operators.push(exp);
                } else if (exp == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        postfix += operands.pop();
                    }
                    if (!operators.isEmpty()) {
                        operators.pop();
                    }
                }
                else {
                    postfix += "$";
                    while (!operators.isEmpty() && operatorPrecedence(operators.peek()) >= operatorPrecedence(exp)) {
                        postfix += operators.pop();
                    }
                    operators.push(exp);
                }
            }
            while (!operators.isEmpty())
                postfix += operators.pop();
            return postfix;
        } catch (Exception e) {
            // TODO: handle exception
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
