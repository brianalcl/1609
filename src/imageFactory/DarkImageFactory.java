package imageFactory;

import java.awt.Color;

import javax.swing.Icon;

public class DarkImageFactory extends ImageFactory{
	public DarkImageFactory(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
	}
	
	public Icon getMap() {
		return getIcon("/res/img/darkMap.png");
	}
	
	public Icon getSquircle() {
		return getIcon("/res/img/darkSquircle.png");
	}
	
	public Icon getEmpty() {
		return getIcon("/res/img/darkEmpty.png");
	}

	public Color getEmptyColor() {
		return new Color(0,0,25);
	}
}
