package bth2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class xulikitu extends JFrame implements ActionListener {
	private JLabel lb1,lb2,lb3,lb4,lb5;
	private JTextField enterField, upperField, lowerField, lowupField,numberField;
	private JButton okButton, resetButton, exitButton;
	private JPanel panel1,panel2,panel3;
	
	public xulikitu()
	{
		lb1 = new JLabel("Enter a String");
		lb2 = new JLabel("To UpperCase");
		lb3 = new JLabel("To LowerCase");
		lb4 = new JLabel("To LowerUpper");
		lb5 = new JLabel("Number of word");
		
		okButton = new JButton("OK");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		okButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		panel1 = new JPanel(new GridLayout(5,2, 0, 25));
		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 0));
		panel3 = new JPanel(new BorderLayout(0,20));
		
		enterField = new JTextField(100);
		upperField = new JTextField(100);
		lowerField = new JTextField(100);
		lowupField = new JTextField(100);
		numberField = new JTextField(100);
		upperField.setEditable(false);
		lowerField.setEditable(false);
		lowupField.setEditable(false);
		
		panel1.add(lb1); panel1.add(enterField);
		panel1.add(lb2); panel1.add(upperField);
		panel1.add(lb3); panel1.add(lowerField);
		panel1.add(lb4); panel1.add(lowupField);
		panel1.add(lb5); panel1.add(numberField);
		
		panel2.add(okButton);
		panel2.add(resetButton);
		panel2.add(exitButton);
		
		panel3.add(panel1, BorderLayout.CENTER);
		panel3.add(panel2, BorderLayout.SOUTH);
		this.add(panel3);
		
		pack();
		setVisible(true);
		setSize(400,300);
		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==okButton) {
			String input = enterField.getText();
			upperField.setText(input.toUpperCase());
			lowerField.setText(input.toLowerCase());
			lowupField.setText(toLowUp(input));
			numberField.setText(Integer.toString(count(input)));
		}
		
		if(e.getSource()== resetButton) {
			enterField.setText("");
			upperField.setText("");
			lowerField.setText("");
			lowupField.setText("");
			numberField.setText("");
		}
		else if(e.getSource()== exitButton) 
		{
			System.exit(0);
		}
		
	}
	public static String toLowUp(String input) {
		char[] charArray = input.toCharArray();
		for(int i =0; i < charArray.length; i++) {
			if(charArray[i] >= 65 && charArray[i] <= 90)
			{
				charArray[i] += 32;
			}
			else if(charArray[i]>= 97 && charArray[i]<= 122) {
				charArray[i] -= 32;
			}
		}
		return new String(charArray);
	}
	public static int count(String input) {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		String[] words = input.split("\\s+");
		return words.length;
	}
	public static void main(String[] args) {
		new xulikitu();
	}

}
