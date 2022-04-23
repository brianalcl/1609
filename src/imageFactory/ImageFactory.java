package imageFactory;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class ImageFactory {
	protected int screenWidth;
	protected int screenHeight;
	
	public ImageFactory(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public Dimension getScreenResolution() {
		return new Dimension(screenWidth, screenHeight);
	}
	
	protected ImageIcon getIcon(String path) {
		ImageIcon icon = new ImageIcon(ImageFactory.class.getResource(path));
		return scale(icon);
	}	
	
	protected ImageIcon scale(ImageIcon imageIcon) {
		int width = screenWidth * imageIcon.getIconWidth() / 1920;
		int height = screenHeight * imageIcon.getIconHeight() / 1080;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	public abstract Icon getMap();
	
	public abstract Icon getSquircle();
}
