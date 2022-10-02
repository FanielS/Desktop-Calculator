package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Calculator extends JFrame implements ActionListener {

    JLabel EquationLabel = new JLabel("", SwingConstants.RIGHT);
    JLabel ResultLabel = new JLabel("0", SwingConstants.RIGHT);

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLocationRelativeTo(null);
        setTitle("Calculator");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(2, 0));
        add(top);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(0, 4));
        add(bottom);

        EquationLabel.setName("EquationLabel");
        EquationLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        ResultLabel.setName("ResultLabel");
        ResultLabel.setFont(new Font("Courier", Font.PLAIN, 38));

        top.add(ResultLabel);
        top.add(EquationLabel);

        String[] names = new String[]{"Seven", "Eight", "Nine", "Divide", "Four", "Five", "Six", "Multiply", "One", "Two", "Three", "Add", "Dot", "Zero", "Equals", "Subtract", "Clear", "Delete"};
        String[] text = new String[]{"7", "8", "9", "\u00F7", "4", "5", "6", "\u00D7", "1", "2", "3", "\u002B", ".", "0", "=", "-", "C", "Del"};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            JButton btn = new JButton(text[i]);
            btn.setName(name);
            btn.addActionListener(this);
            btn.setFocusPainted(false);
            btn.setBackground(Color.lightGray);
            //btn.setForeground(Color.RED);
            btn.setOpaque(true);
            btn.setFont(new Font("Courier", Font.PLAIN, 30));
            bottom.add(btn);
        }
    }


    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        String input = EquationLabel.getText();

        if (Objects.equals(value, "=")) {
            ResultLabel.setText(Parser.getResult(input));
        } else if (Objects.equals(value, "C")) {
            EquationLabel.setText("");
            ResultLabel.setText("0");
        } else if (value == "Del") {
            EquationLabel.setText(input.substring(0, input.length() - 1));
        }
        else {
            EquationLabel.setText(input + value);
        }
    }
}
