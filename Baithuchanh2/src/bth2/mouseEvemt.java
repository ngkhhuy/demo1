package bth2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class mouseEvemt extends JFrame implements MouseListener{
	public mouseEvemt() {
		this.GUI();
	}
	private void GUI() {
		this.setTitle("Mouse Event");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new mouseEvemt();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("You left click the mouse at " + e.getX() + " " + e.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("You press the mouse at " + e.getX() + " " + e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("You release the mouse at " + e.getX() + " " + e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("You Entered the window at " + e.getX() + " " + e.getY());
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("You exit the window at " + e.getX() + " " + e.getY());
		
	}
}

