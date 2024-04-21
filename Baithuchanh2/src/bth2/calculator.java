package bth2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {
	private JLabel lb1, lb2, lb3, lb4;
    private JTextField number1Field, number2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, resetButton, exitButton;
    private JPanel Panel1, Panel2, Panel3, Panel4, Pn;

    public calculator() {
        
    	lb1 = new JLabel("Basic Operations");
    	lb2 = new JLabel("Number 1");
    	lb3 = new JLabel("Number 2");
    	lb4 = new JLabel("Result");
    	
        addButton = new JButton("Addition");
        subtractButton = new JButton("Subtraction");
        multiplyButton = new JButton("Multiplication");
        divideButton = new JButton("Division");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
    	
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        Panel1 = new JPanel(new FlowLayout());
        Panel2 = new JPanel(new GridLayout(3, 2));
        Panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Pn = new JPanel(new GridLayout(4, 1));

        number1Field = new JTextField(10);
        number2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        Panel1.add(lb1);
        
        Panel2.add(lb2); Panel2.add(number1Field);
        Panel2.add(lb3); Panel2.add(number2Field);
        Panel2.add(lb4); Panel2.add(resultField);
     
        Panel3.add(addButton);
        Panel3.add(subtractButton);
        Panel3.add(multiplyButton);
        Panel3.add(divideButton);
        Panel4.add(resetButton);
        Panel4.add(exitButton);
        
        Pn.add(Panel1);
        Pn.add(Panel2);
        Pn.add(Panel3);
        Pn.add(Panel4);
        
        this.add(Pn);
        
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double number1 = Double.parseDouble(number1Field.getText());
            double number2 = Double.parseDouble(number2Field.getText());
            double result = 0.0;

            if (e.getSource() == addButton) {
                result = number1 + number2;
            } else if (e.getSource() == subtractButton) {
                result = number1 - number2;
            } else if (e.getSource() == multiplyButton) {
                result = number1 * number2;
            } else if (e.getSource() == divideButton) {
                result = number1 / number2;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }

        if (e.getSource() == resetButton) {
            number1Field.setText("");
            number2Field.setText("");
            resultField.setText("");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new calculator();
    }

}
