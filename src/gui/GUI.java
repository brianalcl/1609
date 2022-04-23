package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import imageFactory.ImageFactory;

public class GUI extends JFrame {
	
	protected ImageFactory factory;
	
	public GUI(ImageFactory factory) {
		this.factory = factory;
		initialize();
		setVisible(true);
		
	}

	private void initialize() {
		
		setSize((int)factory.getScreenResolution().getWidth() + 16, (int) factory.getScreenResolution().getHeight() + 39);
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
	
	public ImageFactory getImageFactory() {
		return factory;
	}
}
