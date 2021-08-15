package com.alex.andreiev;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BracedExpression {
    private static final List<String> operators = Arrays.asList("+", "-", "/", "*") ;

    public static double calculate(String expression) {
         StringTokenizer tokenizer = new StringTokenizer(expression, " \\+-*/()", true);
         var valueStack = new Stack<Double>();
         var operatorStack = new Stack<String>();

         while (tokenizer.hasMoreTokens()){
             String token = tokenizer.nextToken();
             if (isNumber(token))
                 valueStack.push(Double.parseDouble(token));
             else if (isOperator(token))
                 operatorStack.push(token);
             else if (token.equals(")")) {
                 double val1 = valueStack.pop();
                 double val2 = valueStack.pop();
                 String op = operatorStack.pop();
                 valueStack.push(doOperation(val2, val1, op));
             }
         }
         return valueStack.pop();
     }

    private static boolean isNumber(String str){
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String str){
        return (operators.contains(str));
    }

    private static double doOperation(double val1, double val2, String op) {
        switch (op) {
            case "+":   return val1 + val2;
            case "-":   return val1 - val2;
            case "/":   return val1 / val2;
            case "*":   return val1 * val2;
            default:    throw new ArithmeticException("Incorrect operator provided.");
        }
    }

}
