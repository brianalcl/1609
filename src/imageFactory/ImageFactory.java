package imageFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
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
	
	protected ImageIcon getIcon(String path) {
		ImageIcon icon = new ImageIcon(ImageFactory.class.getResource(path));
		return scale(icon);
	}	
	
	protected ImageIcon scale(ImageIcon imageIcon) {
		int width = screenWidth * imageIcon.getIconWidth() / DEFAULT_WIDTH;
		int height = screenHeight * imageIcon.getIconHeight() / DEFAULT_HEIGHT;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	public abstract Color getColorRandom();
	
	public abstract Color getColor1();	
	
	public abstract Color getColor2();
	
	public abstract Icon getMap();
	
	public abstract Icon getSquircle();
	
	public abstract Icon getEmpty();
	
	public abstract Color getEmptyColor();
	

}
