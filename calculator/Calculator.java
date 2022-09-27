package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JTextField EquationTextField = new JTextField();

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLocationRelativeTo(null);
        setTitle("Calculator");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout());
        add(top);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(0, 4));
        add(bottom);

        EquationTextField.setName("EquationTextField");
        EquationTextField.setFont(new Font("Courier", Font.PLAIN, 30));
        top.add(EquationTextField, SwingConstants.CENTER);

        JButton Seven = new JButton("7");
        Seven.setName("Seven");
        Seven.addActionListener(this);
        Seven.setFocusPainted(false);
        Seven.setBackground(Color.lightGray);
        Seven.setOpaque(true);
        Seven.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Seven);

        JButton Eight = new JButton("8");
        Eight.setName("Eight");
        Eight.addActionListener(this);
        Eight.setFocusPainted(false);
        Eight.setBackground(Color.lightGray);
        Eight.setOpaque(true);
        Eight.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Eight);

        JButton Nine = new JButton("9");
        Nine.setName("Nine");
        Nine.addActionListener(this);
        Nine.setFocusPainted(false);
        Nine.setBackground(Color.lightGray);
        Nine.setOpaque(true);
        Nine.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Nine);

        JButton Divide = new JButton("/");
        Divide.setName("Divide");
        Divide.addActionListener(this);
        Divide.setFocusPainted(false);
        Divide.setBackground(Color.black);
        Divide.setOpaque(true);
        Divide.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Divide);

        JButton Four = new JButton("4");
        Four.setName("Four");
        Four.addActionListener(this);
        Four.setFocusPainted(false);
        Four.setBackground(Color.lightGray);
        Four.setOpaque(true);
        Four.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Four);

        JButton Five = new JButton("5");
        Five.setName("Five");
        Five.addActionListener(this);
        Five.setFocusPainted(false);
        Five.setBackground(Color.lightGray);
        Five.setOpaque(true);
        Five.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Five);

        JButton Six = new JButton("6");
        Six.setName("Six");
        Six.addActionListener(this);
        Six.setFocusPainted(false);
        Six.setBackground(Color.lightGray);
        Six.setOpaque(true);
        Six.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Six);

        JButton Multiply = new JButton("x");
        Multiply.setName("Multiply");
        Multiply.addActionListener(this);
        Multiply.setFocusPainted(false);
        Multiply.setBackground(Color.black);
        Multiply.setOpaque(true);
        Multiply.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Multiply);

        JButton One = new JButton("1");
        One.setName("One");
        One.addActionListener(this);
        One.setFocusPainted(false);
        One.setBackground(Color.lightGray);
        One.setOpaque(true);
        One.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(One);

        JButton Two = new JButton("2");
        Two.setName("Two");
        Two.addActionListener(this);
        Two.setFocusPainted(false);
        Two.setBackground(Color.lightGray);
        Two.setOpaque(true);
        Two.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Two);

        JButton Three = new JButton("3");
        Three.setName("Three");
        Three.addActionListener(this);
        Three.setFocusPainted(false);
        Three.setBackground(Color.lightGray);
        Three.setOpaque(true);
        Three.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Three);

        JButton Add = new JButton("+");
        Add.setName("Add");
        Add.addActionListener(this);
        Add.setFocusPainted(false);
        Add.setBackground(Color.black);
        Add.setOpaque(true);
        Add.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Add);

        JButton Reset = new JButton("C");
        Reset.setName("Reset");
        Reset.addActionListener(this);
        Reset.setFocusPainted(false);
        Reset.setBackground(Color.lightGray);
        Reset.setForeground(Color.RED);
        Reset.setOpaque(true);
        Reset.setFont(new Font("Courier", Font.PLAIN, 30));
        bottom.add(Reset);

        JButton Zero = new JButton("0");
        Zero.setName("Zero");
        Zero.addActionListener(this);
        Zero.setFocusPainted(false);
        Zero.setBackground(Color.lightGray);
        Zero.setOpaque(true);
        Zero.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Zero);

        JButton Equals = new JButton("=");
        Equals.setName("Equals");
        Equals.addActionListener(this);
        Equals.setFocusPainted(false);
        Equals.setBackground(Color.black);
        Equals.setOpaque(true);
        Equals.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Equals);

        JButton Subtract = new JButton("-");
        Subtract.setName("Subtract");
        Subtract.addActionListener(this);
        Subtract.setFocusPainted(false);
        Subtract.setBackground(Color.black);
        Subtract.setOpaque(true);
        Subtract.setFont(new Font("Courier", Font.PLAIN, 20));
        bottom.add(Subtract);


//        JButton Solve = new JButton("solve");
//        Solve.setName("Solve");
//        Solve.setBounds(20, 100, 100, 30);
//        Solve.addActionListener(e -> {
//            String input = EquationTextField.getText();
//            EquationTextField.setText(input + "=" + getResult(input));
//        });
//        add(Solve);
    }

    int getResult(String input) {
        char operator = parseInput(input);
        String[] operands = input.split("\\D");

        return switch (operator) {
            case '-' -> Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
            case '+' -> Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
            case 'x' -> Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]);
            case '/' -> Integer.parseInt(operands[0]) / Integer.parseInt(operands[1]);
            default -> 0;
        };
    }

    char parseInput(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return c;
            }
        }
        return '0';
    }

    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        String input = EquationTextField.getText();

        if (btn == "=") {
            EquationTextField.setText(input + "=" + getResult(input));
        } else if (btn == "C") {
            EquationTextField.setText("");
        } else {
            EquationTextField.setText(input + btn);
        }
    }
}
