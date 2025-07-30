package com.example.calculator;

import java.util.Stack;

public class Calc {


    public static double evaluate(String expression) {
        return evaluatePostfix(toPostfix(expression));
    }

    private static String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = infix.toCharArray();
        int i = 0;

        while (i < chars.length) {
            char c = chars[i];

            if (Character.isDigit(c) || c == '.') {
                while (i < chars.length && (Character.isDigit(chars[i]) || chars[i] == '.')) {
                    postfix.append(chars[i++]);
                }
                postfix.append(" ");
                continue;
            }

            if (c == '-' && (i == 0 || "+-*/%(".indexOf(chars[i - 1]) != -1)) {
                postfix.append(c);
                i++;
                continue;
            }

            if ("+-*/%".indexOf(c) != -1) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }

            i++;
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                    case "%": stack.push(a % b); break;
                }
            }
        }

        return stack.pop();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/':
            case '%': return 2;
        }
        return -1;
    }


}
