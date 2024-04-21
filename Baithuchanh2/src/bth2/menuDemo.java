package bth2;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class menuDemo extends JFrame implements ActionListener{
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	final JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu, editMenu;
	JMenuItem openMenuItem, newMenuItem, saveMenuItem,
	exitMenuItem, cutMenuItem, copyMenuItem, pasteMenuItem;
	public menuDemo() {
		this.GUI();
	}
	public static void main(String[] args) {
		new menuDemo();
	}
	private void GUI() {
		this.setTitle("Menu Demo");
		this.setSize(400, 300);
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		controlPanel = new JPanel(new FlowLayout());
		this.add(headerLabel);
		this.add(controlPanel);
		this.add(statusLabel);
		
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		openMenuItem = new JMenuItem("Open");
        openMenuItem.setActionCommand("Open");
		saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setActionCommand("Save");
		newMenuItem = new JMenuItem("New");
		newMenuItem.setActionCommand("New");
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");
		cutMenuItem = new JMenuItem("Cut");
		cutMenuItem.setActionCommand("Cut");
		copyMenuItem = new JMenuItem("Copy");
		copyMenuItem.setActionCommand("Copy");
		pasteMenuItem = new JMenuItem("Paste");
		pasteMenuItem.setActionCommand("Paste");
		newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        this.setJMenuBar(menuBar);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}