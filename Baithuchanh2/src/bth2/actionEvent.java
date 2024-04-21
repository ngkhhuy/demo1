package bth2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class actionEvent extends JFrame implements ActionListener{
	Button bt;
	List list;
	TextField tf;
	Label lb1;
	Panel pn1, pn2;
	public actionEvent() {
		this.GUI();
	}
	private void GUI() {
		this.setTitle("ActionEventTest");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list = new List(3);
		list.addActionListener(this);
		list.setBounds(100, 50, 100, 80);
		list.add("Tiger");
		list.add("Lion");
		list.add("Elephant");
		list.add("Cat");
		
	    tf = new TextField(15);
	    
		lb1 = new Label("The event is displayed here");
		
		bt = new Button("OK");
		bt.addActionListener(this);
		
		pn1 = new Panel(new FlowLayout(FlowLayout.CENTER));
		pn1.add(bt); pn1.add(tf); pn1.add(list);
		pn2 = new Panel(new FlowLayout(FlowLayout.CENTER));
		pn2.add(lb1);
		
		this.setLayout(new GridLayout(3, 1));
		
		this.add(pn1, Panel.CENTER_ALIGNMENT);
		this.add(pn2);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new actionEvent();
	}
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		if(e.getSource()==list) {
			lb1.setText(list.getItem(list.getSelectedIndex()) + " is displayed here");
		}
		if(e.getSource() == bt) {
			if(tf.getText() != "") {
				lb1.setText(tf.getText() + " is displayed here");
			}else if(tf.getText() == ""){
				lb1.setText("The event is displayed here");
			}
		}
		
		
	}
	
}

