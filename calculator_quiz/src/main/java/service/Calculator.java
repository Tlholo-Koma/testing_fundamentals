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
    }

    private String toPostfix(String expression){
        String postfix = "";
        for (int i = 0; i < expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exp >= '0' && exp <= '9') {
                postfix += exp;
            } else if (exp == '(') {
                postfix += "$";
                operators.push(exp);
            } else if (exp == ')') {
                postfix += "$";
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
    }

    private int operatorPrecedence(char op) {
        if (op == '*' || op == '/')
            return 1;
        else if (op == '+' || op == '-')
            return 0;
        return -1;
    }

    public void calculate(){
        String postfix = toPostfix("");
        String operand = "";
        Double result;
        for (int i = 0; i < postfix.length(); i++) {
            char exp = postfix.charAt(i);
            if (exp == '$') {
                operands.push(Double.valueOf(operand));
            } else if (exp >= '0' && exp <= '9') {
                postfix+=exp;
            } else {
                Double value1 = operands.pop();
                Double value2 = operands.pop(); 
                result = operatorMap.get(exp).execute(value1, value2);
                operands.push(result);
            }
        }
        result = operands.pop();
    }
}
