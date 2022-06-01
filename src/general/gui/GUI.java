package general.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import imageFactory.ImageFactory;

public class GUI extends JFrame {
	
	protected ImageFactory factory;
	protected JPanel panel;
	protected Font font;
	
	public GUI(ImageFactory factory) {
		this.factory = factory;
		this.panel = new JPanel();
		createFont();
		initialize();
		
	}

	private void initialize() {
		setSize((int)factory.getScreenResolution().getWidth() + 16, (int) factory.getScreenResolution().getHeight() + 39);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().add(panel);
		setPanel(new InitialPanel(this));
	}
	
	public void setPanel(JPanel p) {
		getContentPane().remove(panel);
		panel = p;
		getContentPane().add(panel);
		panel.requestFocusInWindow();
		validate();
		repaint();
	}
	
	public ImageFactory getImageFactory() {
		return factory;
	}
	
	private void createFont() {
		font = null;
		try {
			InputStream is =  getClass().getResourceAsStream("/assets/font/futurespore.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (IOException | FontFormatException ex) {
			System.out.println("ERROR: FONT NOT FOUND");
		}
		
	}
	
	public Font getFont() {
		return font;
	}
	
}
