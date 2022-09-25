package factory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;

public class ColorfulFactory extends Factory{
	private Icon squircle;
	private Icon flag;
	private Icon bomb;
	
	public ColorfulFactory(Dimension resolution) {
		super(resolution);
		
		colorDefault = new Color(85, 107, 47);
		colorForeground = new Color(255, 255, 255, 200);
		
		createIcons();
	}
	
	public void setScreenResolution(Dimension resolution) {
		super.setScreenResolution(resolution);
		createIcons();
	}

	private void createIcons() {
		if(screenHeight == DEFAULT_HEIGHT) {
			squircle = getOriginalIcon("/assets/img/r1080/gameImages/common/squircle.png");
			flag = getOriginalIcon("/assets/img/r1080/gameImages/minesweeper/flag.png");
			bomb = getOriginalIcon("/assets/img/r1080/gameImages/minesweeper/bomb.png");
		}
		else {
			squircle = getOriginalIcon("/assets/img/r720/gameImages/common/squircle.png");
			flag = getOriginalIcon("/assets/img/r720/gameImages/minesweeper/flag.png");
			bomb = getOriginalIcon("/assets/img/r720/gameImages/minesweeper/bomb.png");
		}
	}
	
	public Color getColorDefault() {
		return colorDefault;
	}

	public Color getColorForeground() {
		return colorForeground;
	}
	
	public Color getMarkColor(Color color, int f) {
		Color res = color;
		int r = res.getRed();
		int g = res.getGreen();
		int b = res.getBlue();
		boolean editable = false;
		if(r + f >= 0 && r + f <= 255) {
			r += f;
			editable = true;
		}
		if(g + f >= 0 && g + f <= 255) {
			g += f;
			editable = true;
		}
		if(b + f >= 0 && b + f <= 255) {
			b += f;
			editable = true;
		}
		if(editable)
			res = new Color(r, g, b);
		return res;
	}
	
	public Icon getGameIcon(String name) {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameIcons/"+name+".png");
		else
			return getOriginalIcon("/assets/img/r720/gameIcons/"+name+".png");
	}

	public Icon getKeyboard0() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/keyboard0.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/keyboard0.png");
	}
	
	public Icon getKeyboard1() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/keyboard1.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/keyboard1.png");
	}
	
	public Icon getKeyboard2() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/keyboard2.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/keyboard2.png");
	}	
	
	public Icon getKeyboard3() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/keyboard3.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/keyboard3.png");
	}	
	
	public Icon getKeyboard4() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/keyboard4.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/keyboard4.png");
	}	
	
	public Icon getKeyboard5() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/keyboard5.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/keyboard5.png");
	}
	
	public Icon getMouse() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/mouse.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/mouse.png");
	}
	
	public Icon getGuiGameOver() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/guiGameOver.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/guiGameOver.png");
	}

	public Icon getRestart() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/restart.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/restart.png");
	}

	public Icon getHome() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/home.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/home.png");
	}

	public Icon getExit() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/exit.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/exit.png");
	}
	
	public Icon getConfiguration() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/configuration.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/configuration.png");
	}
	
	public Icon getHorizontalMap() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/horizontalMap.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/horizontalMap.png");
	}
	
	public Icon getVerticalMap() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gui/verticalMap.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/verticalMap.png");
	}	
	
	public Icon getEmpty() {
		return null;
	}
	
	public Icon getSquircle() {
		return squircle;
	}
	
	public Icon getFlag() {
		return flag;
	}
	
	public Icon getBomb() {
		return bomb;
	}

}
