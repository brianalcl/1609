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

	public Color getColorRandom() {
		int r = Math.abs(rnd.nextInt() % 255);
		if (r - 100 < 0)
			r += 100;
		int g = Math.abs(rnd.nextInt() % 255);
		if (g - 100 < 0)
			g += 100;
		int b = Math.abs(rnd.nextInt() % 255);
		if (b - 100 < 0)
			b += 100;
		return new Color(r,g,b);
	}

	public Color getColor1() {
		return new Color(150,0,150);
	}
	
	public Color getColor2() {
		return new Color(150,150,0);
	}
}
