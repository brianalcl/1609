package factory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import general.utilities.NRandom;

public abstract class Factory {
	protected int screenWidth;
	protected int screenHeight;
	public static final int DEFAULT_WIDTH = 1920;
	public static final int DEFAULT_HEIGHT = 1080;
	protected Random rnd;
	protected Color colorDefault;
	protected Color colorForeground;
	
	/**
	 * Create a generic factory.
	 * @param screenWidth
	 * @param screenHeight
	 */
	public Factory(Dimension resolution) {
		screenWidth = (int) resolution.getWidth();
		screenHeight = (int) resolution.getHeight();
		rnd = NRandom.getInstance();
	}
	
	/**
	 * Set the default color.
	 * @param colorDefault the default color.
	 */
	public void setColorDefault(Color colorDefault) {
		this.colorDefault = colorDefault;
	}
	
	/**
	 * Sets the screen resolution taking a dimension as a parameter. (width, height)
	 * @param resolution the screen resolution.
	 */
	public void setScreenResolution(Dimension resolution) {
		screenWidth = (int) resolution.getWidth();
		screenHeight = (int) resolution.getHeight();
	}
	
	/**
	 * Returns the screen resolution as a dimension. (width, height)
	 * @return the screen resolution.
	 */
	public Dimension getScreenResolution() {
		return new Dimension(screenWidth, screenHeight);
	}
	
	/**
	 * Returns an image in its original resolution.
	 * @param path the image path.
	 * @return the image.
	 */
	protected ImageIcon getOriginalIcon(String path) {
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		return scale(icon, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * It allows scaling an image based on the resolution passed by parameter. 
	 * Scale taking into account the original size of the image for a resolution of 1920 x 1080.
	 * for example if an image is for 1920 x 1080 in a resolution of 60 x 45 px, 
	 * and we pass a resolution of 1280 x 720 as a parameter, the image is transformed into a 40 x 30 px.
	 * @param imageIcon the image to scale.
	 * @param screenWidth the the width of the resolution to scale.
	 * @param screenHeight the the height of the resolution to scale.
	 * @return the scaled image.
	 */
	protected ImageIcon scale(ImageIcon imageIcon, int screenWidth, int screenHeight) {
		int width = screenWidth * imageIcon.getIconWidth() / DEFAULT_WIDTH;
		int height = screenHeight * imageIcon.getIconHeight() / DEFAULT_HEIGHT;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	/**
	 * Return default color.
	 * @return default color.
	 */
	public abstract Color getColorDefault();	
	
	/**
	 * Return foreground color.
	 * @return foreground color.
	 */
	public abstract Color getColorForeground();	
	
	/**
	 * Allows scaling a color with a factor passed by parameter.
	 * @param color
	 * @param f a factor.
	 * @return new Color.
	 */
	public abstract Color getMarkColor(Color color, int f);
	
	/**
	 * Return the horizontal map icon.
	 * @return the horizontal map icon.
	 */
	public abstract Icon getHorizontalMap();
	
	/**
	 * Return the vertical map icon.
	 * @return the vertical map icon.
	 */
	public abstract Icon getVerticalMap();
	
	/**
	 * Return the configuration icon.
	 * @return the configuration icon.
	 */
	public abstract Icon getConfiguration();
	
	/**
	 * Return the restart icon.
	 * @return the restart icon.
	 */
	public abstract Icon getRestart();
	
	/**
	 * Return the home icon.
	 * @return the home icon.
	 */
	public abstract Icon getHome();
	
	/**
	 * Return the exit icon.
	 * @return the exit icon.
	 */
	public abstract Icon getExit();
	
	/**
	 * Return the gui game over icon.
	 * @return the gui game over icon.
	 */
	public abstract Icon getGuiGameOver();
	
	/**
	 * Return a game icon associated to the name passed by parameter.
	 * @param name a game name.
	 * @return a game icon.
	 */
	public abstract Icon getGameIcon(String name);
	
	/**
	 * Return the keyboard0 icon. this keyboard contains the space.
	 * @return the keyboard0 icon.
	 */
	public abstract Icon getKeyboard0();
	
	/**
	 * Return the keyboard1 icon. this keyboard contains the keys: W, A, S and D.
	 * @return the keyboard1 icon.
	 */
	public abstract Icon getKeyboard1();
	
	/**
	 * Return the keyboard2 icon. this keyboard contains the keys: W, A, S, D and SPACE.
	 * @return the keyboard2 icon.
	 */
	public abstract Icon getKeyboard2();
	
	/**
	 * Return the keyboard3 icon. this keyboard contains the keys: W, and S.
	 * @return the keyboard3 icon.
	 */
	public abstract Icon getKeyboard3();
	
	/**
	 * Return the keyboard4 icon. this keyboard contains the keys: A, D, ande SPACE.
	 * @return the keyboard4 icon.
	 */
	public abstract Icon getKeyboard4();
	
	/**
	 * Return the keyboard5 icon. this keyboard contains the keys: 1, 2, 3, 4, 5, 6, 7, 8, 9 and 0.
	 * @return the keyboard5 icon.
	 */
	public abstract Icon getKeyboard5();
	
	/**
	 * Return the mouse icon.
	 * @return the mouse icon.
	 */
	public abstract Icon getMouse();
	
	/**
	 * Return the squircle icon.
	 * @return the squircle icon.
	 */
	public abstract Icon getSquircle();
	
	/**
	 * Return the empty icon.
	 * @return the empty icon.
	 */
	public abstract Icon getEmpty();

	/**
	 * Return the flag icon.
	 * @return the flag icon.
	 */
	public abstract Icon getFlag();
	
	/**
	 * Return the bomb icon.
	 * @return the bomb icon.
	 */
	public abstract Icon getBomb();
	

}
