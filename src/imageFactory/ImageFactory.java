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

	public abstract Icon getMouse();
	
	public abstract Icon getEmptyNumber();
	
	public abstract Icon get0();
	
	public abstract Icon get1();
	
	public abstract Icon get2();
	
	public abstract Icon get3();
	
	public abstract Icon get4();
	
	public abstract Icon get5();
	
	public abstract Icon get6();
	
	public abstract Icon get7();
	
	public abstract Icon get8();
	
	public abstract Icon get9();

	public abstract Icon getConfiguration();

}
