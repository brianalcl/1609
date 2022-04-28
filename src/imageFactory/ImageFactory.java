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

public abstract class ImageFactory {
	protected int screenWidth;
	protected int screenHeight;
	public static final int DEFAULT_WIDTH = 1920;
	public static final int DEFAULT_HEIGHT = 1080;
	protected Random rnd;
	
	public ImageFactory(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		rnd = new Random();
	}
	
	public Dimension getScreenResolution() {
		return new Dimension(screenWidth, screenHeight);
	}
	
	protected ImageIcon getIcon(String path, int screenWidth, int screenHeight) {
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
			InputStream is =  getClass().getResourceAsStream("/res/font/futurespore.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (IOException | FontFormatException ex) {
			System.out.println("ERROR: FONT NOT FOUND");
		}
		
		return font;
	}
	
	
	public abstract Color getColorRandom();
	
	public abstract Color getColor1();	
	
	public abstract Color getColor2();
	
	public abstract Color getForegroundColor();
	
	public abstract Icon getMap();
	
	public abstract Icon getSquircle();
	
	public abstract Icon getEmpty();
	
	public abstract Color getEmptyColor();
	
	
}
