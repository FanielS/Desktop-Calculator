package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Faniel S. Abraham
 * version 1.0
 */
public class Calculator extends JFrame implements ActionListener {

    static JLabel EquationLabel = new JLabel("", SwingConstants.RIGHT);
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
        EquationLabel.setBackground(Color.BLACK);
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
            btn.setOpaque(true);
            btn.setFont(new Font("Courier", Font.PLAIN, 30));
            bottom.add(btn);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        String input = EquationLabel.getText();
        EquationLabel.setForeground(Color.black);

        switch (value) {
            case "=":
                if (input.isEmpty()) return;
                char lastChar = input.charAt(input.length() - 1);
                if (input.replaceAll("\\d", "").equals("")) {  //if only number, put it to result label
                    ResultLabel.setText(input);
                    return;
                }

                if (lastChar == '\u00F7' || lastChar == '\u00D7' || lastChar == '\u002B' || lastChar == '-') {
                    EquationLabel.setForeground(Color.RED.darker());  //notify user that the input has illegal format by changing colour
                    return;
                }
                String result = Parser.getResult(input);
                if (!result.equals("ERROR")) ResultLabel.setText(Parser.getResult(input));
                break;

            case "C":
                EquationLabel.setText("");
                ResultLabel.setText("0");
                break;

            case "Del":
                EquationLabel.setText(input.substring(0, input.length() - 1));
                break;
            case "\u00F7":
            case "\u00D7":
            case "\u002B":
            case "-":
                if (input.equals("")) return;  //expression does not start with operator
                if (input.matches("\\D?\\.\\d")) {  //format dot character before adding operator
                    input = "0" + input;
                    EquationLabel.setText(input + value);
                }

                lastChar = input.charAt(input.length() - 1);
                if (lastChar == '\u00F7' || lastChar == '\u00D7' || lastChar == '\u002B' || lastChar == '-') {
                    input = input.substring(0, input.length() - 1);
                    EquationLabel.setText(input + value);
                } else {
                    EquationLabel.setText(input + value);
                }
                break;

            case ".":
                // if dot character is inserted without a digit before it, add "0" before it
                if (input.equals("") || !Character.isDigit(input.charAt(input.length() - 1))) {
                    input = String.format("%s%d%s", input, 0, value);
                    EquationLabel.setText(input);
                } else {
                    EquationLabel.setText(input + value);
                }
                break;
            default:
                EquationLabel.setText(input + value);
        }
    }
}



