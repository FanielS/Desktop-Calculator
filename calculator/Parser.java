package calculator;

import java.awt.*;
import java.util.ArrayDeque;

/**
 * @author Faniel S. Abraham
 * version 1.0
 */
public class Parser {
    /**
     * returns the precedence of an operator
     * @param c -- operator
     * @return -- int value (lower value for lower precedence)
     */
    static int getPrecedence(char c) {
        switch (c) {
            case '\u002B':
            case '-':
                return 1;
            case '\u00D7':
            case '\u00F7':
                return 2;
            default:
                System.out.println("something went wrong!");
                return -1;
        }
    }

    /**
     * changes an infix form of an expression to postfix form
     * @param exp -- infix expression
     * @return - String type of postfix expression
     */
    static String infixToPost(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < exp.length(); ++i) {
            if (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.') {
                res.append(exp.charAt(i));
            } else {
                res.append(' '); // to separate numbers from one another in the string (res)
                while (!stack.isEmpty() && getPrecedence(exp.charAt(i)) <= getPrecedence(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.push(exp.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    /**
     * calculates result from a postfix expression and returns result
     * @param input - user fed expression (expect an infix expression)
     * @return - the calculated value in string type
     */
    static String getResult(String input) {
        String postFix = infixToPost(input);
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < postFix.length(); i++) {
            char c = postFix.charAt(i);

            if (c == ' ') continue;

            //get all digits of a number (N.B numbers are separated by " " in the postfix)
            else if (Character.isDigit(c)) {
                String n = "";
                while (Character.isDigit(c) || c == '.') {
                    n += c;
                    i++;
                    c = postFix.charAt(i);
                }
                i--; //so that the last iteration do not run out of index
                stack.push(Double.parseDouble(n));
            }

            else {
                double b = stack.pop();
                double a = stack.pop();

                switch (c) {
                    case '\u002B' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '\u00F7' -> {
                        if (b == 0) {
                            //illegal operation, notify user by changing color.
                            Calculator.EquationLabel.setForeground(Color.RED.darker());
                            return "ERROR";
                        }
                        stack.push(a / b);
                    }
                    case '\u00D7' -> stack.push(a * b);
                }
            }
        }
        //round to ten decimal place
        return formatResult(Math.round(stack.pop() * 10000000000D) / 10000000000D);
    }

    /**
     * formats result - deletes zero after decimal and keep if non zero.
     * @param result - calculated result of the initial expression
     * @return - formatted result String type
     */
    static String formatResult(double result) {
        if (result % 1 > 0) {
            return String.valueOf(result);
        } else {
            return String.valueOf(result).replaceAll("\\.0", "");
        }
    }
}
