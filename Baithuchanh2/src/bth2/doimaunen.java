package bth2; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class doimaunen extends JFrame implements ActionListener {
	
	JButton redButton,greenButton,blueButton,thoatButton;
	JPanel panel1,panel2;

    public doimaunen(String st) {
    	super(st);
    	this.GUI();
    }
    public void GUI() {
    	
    	redButton = new JButton("RED");
    	greenButton = new JButton("GREEN");
    	blueButton = new JButton("BLUE");
    	thoatButton = new JButton("Thoat");
    	
    	redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        thoatButton.addActionListener(this);
        
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2 = new JPanel(new BorderLayout());
        
        panel1.add(redButton);
        panel1.add(greenButton);
        panel1.add(blueButton);
        panel1.add(thoatButton);
        
        panel2.add(panel1, BorderLayout.SOUTH);
        this.setSize(450, 450);
        this.add(panel2);

        //setBackground(Color.white);
        show();
    }

    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == redButton) {
            	panel1.setBackground(Color.red);
            	panel2.setBackground(Color.red);
            } else if (e.getSource() == greenButton) {
            	panel1.setBackground(Color.green);
            	panel2.setBackground(Color.green);
            } else if (e.getSource() == blueButton) {
            	panel1.setBackground(Color.blue);
            	panel2.setBackground(Color.blue);
            } else if (e.getSource() == thoatButton) {
                System.exit(0);
            }
    }
    public static void main(String[] args) {
        new doimaunen("doi mau nen");
        
    }
}
