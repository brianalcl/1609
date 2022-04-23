package imageFactory;

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
}
