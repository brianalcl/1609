package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	public GUI() {
		initialize();
		setVisible(true);
	}

	private void initialize() {
		setSize(1296, 759);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel(new InitialPanel(this));
	}
	
	public void setPanel(JPanel p) {
		getContentPane().removeAll();
		getContentPane().add(p);
		repaint();
	}
}
