package imageFactory;

import java.awt.Color;

import javax.swing.Icon;

public class DarkImageFactory extends ImageFactory{
	public DarkImageFactory(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
	}
	
	public Icon getMap() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/darkMap.png");
		else
			return getOriginalIcon("/assets/img/darkMap720.png");
	}
	
	public Icon getSquircle() {
		return getOriginalIcon("/assets/img/darkSquircle.png");
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

	public Color getColorCyan() {
		return new Color(0,80,80);
	}
	
	public Color getForegroundColor() {
		return new Color(200, 200, 200);
	}
	
	public Icon getEmpty() {
		return null;
	}

	public Icon getEmptyIcon() {
		return getOriginalIcon("/assets/img/icons/emptyIcon.png");
	}
	
	public Icon getIcon(String name) {
		return getOriginalIcon("/assets/img/icons/"+name+".png");
	}

	public Icon getKeyboard0() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/keyboard0.png");
		else
			return getOriginalIcon("/assets/img/keyboard0720.png");
	}
	
	public Icon getKeyboard1() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/keyboard1.png");
		else
			return getOriginalIcon("/assets/img/keyboard1720.png");
	}
	
	public Icon getKeyboard2() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/keyboard2.png");
		else
			return getOriginalIcon("/assets/img/keyboard2720.png");
	}
	
	public Icon getMouse() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/mouse.png");
		else
			return getOriginalIcon("/assets/img/mouse720.png");
	}

	public Icon getGuiGameOver() {
		return getOriginalIcon("/assets/img/guiGameOver.png");
	}

	public Icon getRestart() {
		return getOriginalIcon("/assets/img/restart.png");
	}

	public Icon getHome() {
		return getOriginalIcon("/assets/img/home.png");
	}

	public Icon getExit() {
		return getOriginalIcon("/assets/img/exit.png");
	}
}
