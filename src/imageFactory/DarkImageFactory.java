package imageFactory;

import java.awt.Color;

import javax.swing.Icon;

public class DarkImageFactory extends ImageFactory{
	public DarkImageFactory(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
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

	public Color getColorDarkCyan() {
		return new Color(0,67,67);
	}
	
	public Color getForegroundColor() {
		return new Color(200, 200, 200);
	}
	
	public Color getColorRebeccaPurple() {
		return new Color(49, 24, 74);
	}
	
	public Icon getEmpty() {
		return null;
	}

	public Icon getEmptyIcon() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameIcons/emptyIcon1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameIcons/emptyIcon720.png");
	}
	
	public Icon getIcon(String name) {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameIcons/"+name+"Icon1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameIcons/"+name+"Icon720.png");
	}

	public Icon getKeyboard0() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/keyboard0-1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/keyboard0-720.png");
	}
	
	public Icon getKeyboard1() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/keyboard1-1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/keyboard1-720.png");
	}
	
	public Icon getKeyboard2() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/keyboard2-1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/keyboard2-720.png");
	}
	
	public Icon getMouse() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/mouse1080.png");
		else
			return getOriginalIcon("/assets/img/mouse720.png");
	}

	public Icon getGuiGameOver() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/guiGameOver1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/guiGameOver720.png");
	}

	public Icon getRestart() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/menuIcons/restart1080.png");
		else
			return getOriginalIcon("/assets/img/r720/menuIcons/restart720.png");
	}

	public Icon getHome() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/menuIcons/home1080.png");
		else
			return getOriginalIcon("/assets/img/r720/menuIcons/home720.png");
	}

	public Icon getExit() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/menuIcons/exit1080.png");
		else
			return getOriginalIcon("/assets/img/r720/menuIcons/exit720.png");
	}
	
	public Icon getMap() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/map1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/map720.png");
	}
	
	public Icon getSquircle() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/squircle1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/squircle720.png");
	}

}
