package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setTitle("Calculator");
        setLayout(null);
        setVisible(true);

        JTextField EquationTextField = new JTextField();
        EquationTextField.setBounds(20, 40, 200, 30);
        EquationTextField.setName("EquationTextField");
        add(EquationTextField);

        JButton Solve = new JButton("solve");
        Solve.setName("Solve");
        Solve.setBounds(20, 100, 100, 30);
        Solve.addActionListener(e -> {
            String input = EquationTextField.getText();
            EquationTextField.setText(input + "=" + getResult(input));
        });
        add(Solve);

    }

    int getResult(String input) {
        char operator = parseInput(input);
        String[] operands = input.split("\\D");

        return switch (operator) {
            case '-' -> Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
            case '+' -> Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
            case '*' -> Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]);
            case '/' -> Integer.parseInt(operands[0]) / Integer.parseInt(operands[1]);
            default -> 0;
        };
    }

    char parseInput(String input) {
        for (char c: input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return c;
            }
        }
        return '0';
    }
}
