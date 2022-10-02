package calculator;

import java.util.ArrayDeque;

public class Parser {

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

    static String infixToPost(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < exp.length(); ++i) {
            if (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.') {
                res.append(exp.charAt(i));
            } else {
                res.append(' ');
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

    static String getResult(String input) {
        String postFix = infixToPost(input);
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < postFix.length(); i++) {
            char c = postFix.charAt(i);

            if (c == ' ') continue;

            else if (Character.isDigit(c)) {
                String n = "";
                while (Character.isDigit(c) || c == '.') {
                    n += c;
                    i++;
                    c = postFix.charAt(i);
                }
                i--;
                stack.push(Double.parseDouble(n));
            }

            else {
                double b = stack.pop();
                double a = stack.pop();

                switch (c) {
                    case '\u002B' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '\u00F7' -> stack.push(a / b);
                    case '\u00D7' -> stack.push(a * b);
                }
            }
        }
        return formatResult(stack.pop());
    }

    static String formatResult(double result) {
        if (result % 1 > 0) {
            return String.valueOf(result);
        } else {
            return String.valueOf(result).split("\\.")[0];
        }
    }
}
