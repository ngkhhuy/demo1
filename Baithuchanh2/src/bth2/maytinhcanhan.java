package bth2;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import javax.swing.*;


public class maytinhcanhan extends JFrame implements ActionListener {
	TextField tf1;
	Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17;
	Panel pn1,pn2, pn;
	public void GUI() {
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tf1 = new TextField(1000);
		
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		bt6 = new Button("6");
		bt7 = new Button("7");
		bt8 = new Button("8");
		bt9 = new Button("9");
		bt10 = new Button("0");
		bt11 = new Button(".");
		bt12 = new Button("C");
		bt13 = new Button("/");
		bt14 = new Button("*");
		bt15 = new Button("-");
		bt16 = new Button("+");
		bt17 = new Button("=");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
		bt8.addActionListener(this);
		bt9.addActionListener(this);
		bt10.addActionListener(this);
		bt11.addActionListener(this);
		bt12.addActionListener(this);
		bt13.addActionListener(this);
		bt14.addActionListener(this);
		bt15.addActionListener(this);
		bt16.addActionListener(this);
		bt17.addActionListener(this);
		Dimension preferred = bt17.getPreferredSize();
		preferred.width = 60;
	    bt17.setPreferredSize(preferred);
		
		pn1 = new Panel (new GridLayout(4,4));
		pn2 = new Panel(new BorderLayout());
		this.setLayout(new BorderLayout());
		
		pn1.setSize(200,200);
		pn1.add(bt7);
		pn1.add(bt8);
		pn1.add(bt9);
		pn1.add(bt13);
		pn1.add(bt4);
		pn1.add(bt5);
		pn1.add(bt6);
		pn1.add(bt14);
		pn1.add(bt1);
		pn1.add(bt2);
		pn1.add(bt3);
		pn1.add(bt15);
		pn1.add(bt10);
		pn1.add(bt11);
		pn1.add(bt12);
		pn1.add(bt16);
		
		pn2.add(pn1, BorderLayout.CENTER);
		pn2.add(bt17, BorderLayout.EAST);
		
		this.add(tf1,BorderLayout.NORTH);
		this.add(pn2,BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt10) {
			tf1.setText(tf1.getText() + "0");
		}
	if(e.getSource() == bt1) {
		tf1.setText(tf1.getText() + "1");
	}
	if(e.getSource() == bt2) {
		tf1.setText(tf1.getText() + "2");
	}
	if(e.getSource() == bt3) {
		tf1.setText(tf1.getText() + "3");
	}
	if(e.getSource() == bt4) {
		tf1.setText(tf1.getText() + "4");
	}
	if(e.getSource() == bt5) {
		tf1.setText(tf1.getText() + "5");
	}
	if(e.getSource() == bt6) {
		tf1.setText(tf1.getText() + "6");
	}
	if(e.getSource() == bt7) {
		tf1.setText(tf1.getText() + "7");
	}
	if(e.getSource() == bt8) {
		tf1.setText(tf1.getText() + "8");
	}
	if(e.getSource() == bt9) {
		tf1.setText(tf1.getText() + "9");
	}
	if(e.getSource() == bt16) {
		tf1.setText(tf1.getText() + "+");
	}
	if(e.getSource() == bt15) {
		tf1.setText(tf1.getText() + "-");
	}
	if(e.getSource() == bt14) {
		tf1.setText(tf1.getText() + "*");
	}
	if(e.getSource() == bt13) {
		tf1.setText(tf1.getText() + "/");
	}
	if(e.getSource() == bt11) {
		tf1.setText(tf1.getText() + ".");
	}
	if(e.getSource() == bt12) {
		tf1.setText("");
	}
	if(e.getSource() == bt17) {
		tf1.setText(Double.toString(evaluatetextpression(tf1.getText())));
	}
	}
	private double evaluatetextpression(String text) {
		// TODO Auto-generated method stub
		text = text.replaceAll("\\s+", "");

        Stack<Double> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < text.length() && (Character.isDigit(text.charAt(i)) || text.charAt(i) == '.')) {
                    sb.append(text.charAt(i++));
                }
                i--;
                num.push(Double.parseDouble(sb.toString()));
            } else if (c == '*' || c == '/') {
                while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                	num.push(applyOperation(op.pop(), num.pop(), num.pop()));
                }
                op.push(c);
            } else if (c == '+' || c == '-') {
                while (!op.isEmpty() && (op.peek() == '+' || op.peek() == '-' ||
                		op.peek() == '*' || op.peek() == '/')) {
                	num.push(applyOperation(op.pop(), num.pop(), num.pop()));
                }
                op.push(c);
            }
        }
        while (!op.isEmpty()) {
        	num.push(applyOperation(op.pop(), num.pop(), num.pop()));
        }
        return num.pop();
		
	}
	private Double applyOperation(char operator, double b, double a) {
		// TODO Auto-generated method stub
		 switch (operator) {
         case '+':
             return a + b;
         case '-':
             return a - b;
         case '*':
             return a * b;
         case '/':
             if (b == 0) {
                 throw new ArithmeticException("Division by zero");
             }
             return a / b;
         default:
             throw new IllegalArgumentException("Invalid operator");
     }
	}
	public maytinhcanhan(String st) {
		super();
		this.GUI();
		
	}
	public static void main(String[] args) {
		new maytinhcanhan("Calculator");
	}
	

}
