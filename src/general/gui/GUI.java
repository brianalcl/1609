package general.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import factory.Factory;

public class GUI extends JFrame {
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Factory factory;
	protected JPanel panel;
	protected Font font;
	
	/**
	 * Create the frame. Receives by parameter a factory.
	 * @param factory a factory.
	 */
	public GUI(Factory factory) {
		this.factory = factory;
		this.panel = new JPanel();
		initialize();
		createFont();
	}
	
	/**
	 * Initialize the GUI.
	 */
	private void initialize() {
		setSize((int)factory.getScreenResolution().getWidth() + 16, (int) factory.getScreenResolution().getHeight() + 39);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setPanel(new InitialPanel(this));
	}
	
	/**
	 * Set a panel passed by parameter in the frame.
	 * @param p the panel.
	 */
	public void setPanel(JPanel p) {
		getContentPane().remove(panel);
		panel = p;
		getContentPane().add(panel);
		panel.requestFocusInWindow();
		validate();
		repaint();
	}
	
	/**
	 * Return the factory.
	 * @return the factory.
	 */
	public Factory getImageFactory() {
		return factory;
	}
	
	/**
	 * Create the font.
	 */
	private void createFont() { // Since the GUI is created only once, the font is also created only once.
		font = null;
		try {
			InputStream is =  getClass().getResourceAsStream("/assets/font/futurespore.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (IOException | FontFormatException ex) {
			System.out.println("ERROR: FONT NOT FOUND");
		}
	}
	
	/**
	 * Return the font.
	 * @return the font.
	 */
	public Font getTheFont() {
		return font;
	}
	
}
