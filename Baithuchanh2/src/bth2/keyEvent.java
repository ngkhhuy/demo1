package bth2;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class keyEvent extends JFrame implements KeyListener {
    private Label label;
 
    public keyEvent() {
    	
        label = new Label();
        label.setBounds(200, 50, 100, 250);
        this.addKeyListener(this);
        add(label);
        setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new keyEvent();
    }

	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyPressed(KeyEvent e) {
		label.setText(e.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
