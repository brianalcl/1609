package imageFactory;

import java.awt.Color;

import javax.swing.Icon;

public class DarkImageFactory extends ImageFactory{
	public DarkImageFactory(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
	}
	
	public Icon getMap() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getIcon("/assets/img/darkMap.png", DEFAULT_WIDTH, DEFAULT_HEIGHT);
		else
			return getIcon("/assets/img/darkMap720.png", DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Icon getSquircle() {
		return getIcon("/assets/img/darkSquircle.png", DEFAULT_WIDTH, DEFAULT_HEIGHT);
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
	
	public Color getForegroundColor() {
		return new Color(200, 200, 200);
	}
	
	public Icon getEmpty() {
		return null;
	}
}
