package imageFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import general.utilities.NRandom;

public abstract class ImageFactory {
	protected int screenWidth;
	protected int screenHeight;
	public static final int DEFAULT_WIDTH = 1920;
	public static final int DEFAULT_HEIGHT = 1080;
	protected Random rnd;
	protected Color colorDefault;
	protected Color colorForeground;
	
	public ImageFactory(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		rnd = NRandom.getInstance();
	}
	
	public void setColorDefault(Color colorDefault) {
		this.colorDefault = colorDefault;
	}
	
	public void setScreenResolution(Dimension d) {
		screenWidth = (int) d.getWidth();
		screenHeight = (int) d.getHeight();
	}
	
	public Dimension getScreenResolution() {
		return new Dimension(screenWidth, screenHeight);
	}
	
	protected ImageIcon getOriginalIcon(String path) {
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		return scale(icon, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	protected ImageIcon scale(ImageIcon imageIcon, int screenWidth, int screenHeight) {
		int width = screenWidth * imageIcon.getIconWidth() / DEFAULT_WIDTH;
		int height = screenHeight * imageIcon.getIconHeight() / DEFAULT_HEIGHT;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	public abstract Color getColorDefault();
	
	public abstract Color getColorPurple();
	
	public abstract Color getColorDarkCyan();
	
	public abstract Color getColorSienna();
	
	public abstract Color getColorForeground();	
	
	public abstract Color getColorEmpty();
	
	public abstract Color getColorPeru();
	
	public abstract Color getColorRoyalBlue();
	
	public abstract Color getColorMediumOrchid();
	
	public abstract Color getColorDarkOliveGreen();
	
	public abstract Color getColorCrimson();
	
	public abstract Color getColorDarkRed();
	
	public abstract Color getColorDarkGreen();
	
	public abstract Color getColorDarkSlateGray();
	
	public abstract Color getColorDarkGoldenRod();
	
	public abstract Icon getMapHorizontal();
	
	public abstract Icon getMapVertical();
	
	public abstract Icon getRestart();
	
	public abstract Icon getHome();
	
	public abstract Icon getExit();
	
	public abstract Icon getGuiGameOver();
	
	public abstract Icon getSquircle();
	
	public abstract Icon getEmpty();
	
	public abstract Icon getIcon(String name);

	public abstract Icon getKeyboard0();
	
	public abstract Icon getKeyboard1();
	
	public abstract Icon getKeyboard2();
	
	public abstract Icon getKeyboard3();
	
	public abstract Icon getKeyboard4();

	public abstract Icon getMouse();

	public abstract Icon getConfiguration();

	public abstract Icon getKeyboard5();

}
