package imageFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import general.random.NRandom;

public abstract class ImageFactory {
	protected int screenWidth;
	protected int screenHeight;
	public static final int DEFAULT_WIDTH = 1920;
	public static final int DEFAULT_HEIGHT = 1080;
	protected Random rnd;
	
	public ImageFactory(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		rnd = NRandom.getInstance();
	}
	
	public Dimension getScreenResolution() {
		return new Dimension(screenWidth, screenHeight);
	}
	
	protected ImageIcon getOriginalIcon(String path) {
		ImageIcon icon = new ImageIcon(ImageFactory.class.getResource(path));
		return scale(icon, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	protected ImageIcon getScaledIcon(String path) {
		ImageIcon icon = new ImageIcon(ImageFactory.class.getResource(path));
		return scale(icon, screenWidth, screenHeight);
	}
	
	protected ImageIcon scale(ImageIcon imageIcon, int screenWidth, int screenHeight) {
		int width = screenWidth * imageIcon.getIconWidth() / DEFAULT_WIDTH;
		int height = screenHeight * imageIcon.getIconHeight() / DEFAULT_HEIGHT;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	public Font getFont() {
		Font font = null;
		try {
			InputStream is =  getClass().getResourceAsStream("/assets/font/futurespore.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (IOException | FontFormatException ex) {
			System.out.println("ERROR: FONT NOT FOUND");
		}
		
		return font;
	}
	
	
	public abstract Color getColorRandom();
	
	public abstract Color getColorDarkCyan();
	
	public abstract Color getColorRebeccaPurple();
	
	public abstract Color getForegroundColor();	
	
	public abstract Color getEmptyColor();
	
	public abstract Color getColorBrown();
	
	public abstract Icon getMap();
	
	public abstract Icon getRestart();
	
	public abstract Icon getHome();
	
	public abstract Icon getExit();
	
	public abstract Icon getGuiGameOver();
	
	public abstract Icon getSquircle();
	
	public abstract Icon getEmpty();
	
	public abstract Icon getEmptyIcon();
	
	public abstract Icon getIcon(String name);

	public abstract Icon getKeyboard0();
	
	public abstract Icon getKeyboard1();
	
	public abstract Icon getKeyboard2();

	public abstract Icon getMouse();

	

}
