import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Calculator implements ActionListener {

    JFrame frame; // the pop-up window
    JLabel label;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[14];
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JButton perButton, clreButton;
    JButton invButton, sqrButton, sqrtButton, negButton;
    JPanel panel;

    Font myFont = new Font("Digital", Font.PLAIN, 15);

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    // creating a constructor
    Calculator() {

        ImageIcon icon = new ImageIcon("Calculator/calc.jpeg");

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(344, 540);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(255, 212, 224));
        frame.setIconImage(icon.getImage());

        textField = new JTextField(40);
//        textField.setVisible(false);
        textField.setBounds(2, 50, 325, 100);
        textField.setHorizontalAlignment(JTextField.RIGHT);
//        textField.setText("0");
        textField.setFont(new Font("Digital", Font.BOLD, 30));

        label = new JLabel();
        label.setVisible(true);
        label.setBounds(2, 4, 325, 20);
        label.setFont(new Font("Digital", Font.BOLD, 15));
        label.setForeground(Color.black);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("←");
        clrButton = new JButton("C");
        perButton = new JButton("%");
        clreButton = new JButton("CE");
        invButton = new JButton("1/x");
        sqrButton = new JButton("x^2");
        sqrtButton = new JButton("√");
        negButton = new JButton("+/-");


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = perButton;
        functionButtons[9] = clreButton;
        functionButtons[10] = invButton;
        functionButtons[11] = sqrButton;
        functionButtons[12] = sqrtButton;
        functionButtons[13] = negButton;

        for (int i = 0; i < 14; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBackground(new Color(255, 186, 240));
            functionButtons[i].setFocusable(false);
        }

        functionButtons[5].setBackground(new Color(236, 186, 255));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBackground(new Color(236, 186, 255));
//            numberButtons[i].setForeground(new Color(255,212,224));
            numberButtons[i].setVerticalTextPosition(JButton.CENTER);
            numberButtons[i].setHorizontalTextPosition(JButton.CENTER);
            numberButtons[i].setFocusable(false);

        }

        panel = new JPanel();
        panel.setBounds(2, 165, 325, 335);
        panel.setLayout(new GridLayout(6, 4, 5, 5));
        panel.setBackground(new Color(255, 212, 224));


        panel.add(perButton);
        panel.add(clreButton);
        panel.add(clrButton);
        panel.add(delButton);

        panel.add(invButton);
        panel.add(sqrButton);
        panel.add(sqrtButton);
        panel.add(divButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);

        frame.add(textField);
        frame.add(label);
        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        // creating an instance of Calculator class
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        textField.setText("");

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }

            if (e.getSource() == functionButtons[i]) {

            }}
        if (e.getSource() == perButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            double percent = num1 / 100;
            String string = Double.toString(percent);
            textField.setText(string);
            label.setText(str + "%");
        }

        if (e.getSource() == sqrButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
            label.setText("sqr(" + str + ")");
        }

        if (e.getSource() == sqrtButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            double squareroot = Math.sqrt(num1);
            String string = Double.toString(squareroot);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
            label.setText("√(" + str + ")");
        }

        if (e.getSource() == invButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            double inverse = 1/num1;
            String string = Double.toString(inverse);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
            label.setText("1/(" + str + ")");
        }

        if (e.getSource() == divButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            label.setText(str + " ÷");
        }

        if (e.getSource() == multButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            label.setText(str + " ×");
        }

        if (e.getSource() == subButton) {
//            System.out.println(bt);
//            if (!bt.equals(String.valueOf(subButton))) {
//                bt =
//            }
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            label.setText(str + " -");
        }

        if (e.getSource() == addButton) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            label.setText(str + " +");

        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
            String string = Double.toString(result);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
            label.setText("");
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            label.setText("");
        }

        if (e.getSource() == clreButton) {
            textField.setText("");
        }

    }
}

