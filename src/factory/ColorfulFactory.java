package factory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;

public class ColorfulFactory extends Factory{
	private Icon squircle;
	private Icon flag;
	private Icon bomb;
	private Color colorEmptyColor;
	private Color colorPurple;
	private Color colorSienna;
	private Color colorDarkCyan;
	private Color colorPeru;
	private Color colorRoyalBlue;
	private Color colorMediumOrchid;
	private Color colorDarkOliveGreen;
	private Color colorCrimson;
	private Color colorDarkRed;
	private Color colorDarkGreen;
	private Color colorDarkGoldenRod;
	private Color colorDarkSlateGray;
	
	public ColorfulFactory(Dimension resolution) {
		super(resolution);
		
		colorDarkSlateGray = new Color(47, 79, 79);
		colorDarkCyan = new Color(0, 139, 139);
		colorDarkGreen = new Color(0, 100, 0);
		colorRoyalBlue = new Color(65, 105, 225);
		colorPeru = new Color(205, 133, 63);		
		colorDarkOliveGreen = new Color(85, 107, 47);
		colorDarkGoldenRod = new Color(184, 134, 11);
		colorMediumOrchid = new Color(186, 85, 211);
		colorDarkRed = new Color(139, 0, 0);
		colorSienna = new Color(160, 82, 45);
		colorPurple = new Color(128, 0, 128);
		colorCrimson = new Color(220, 20, 60);

		colorEmptyColor = new Color(0,0,0);
		colorForeground = new Color(255, 255, 255, 200);
		colorDefault = colorDarkOliveGreen;
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
	
	public Color getColorEmpty() {
		return colorEmptyColor;
	}

	public Color getColorDarkCyan() {
		return colorDarkCyan;
	}
	
	public Color getColorForeground() {
		return colorForeground;
	}
	
	public Color getColorSienna() {
		return colorSienna;
	}
	
	public Color getColorDefault() {
		return colorDefault; 
	}
	
	public Color getColorPurple() {
		return colorPurple;
	}
	
	public Color getColorPeru() {
		return colorPeru;
	}
	
	public Color getColorRoyalBlue() {
		return colorRoyalBlue;
	}
	
	public Color getColorMediumOrchid() {
		return colorMediumOrchid;
	}
	
	public Color getColorDarkOliveGreen() {
		return colorDarkOliveGreen;
	}
	
	public Color getColorCrimson() {
		return colorCrimson;
	}
	
	public Color getColorDarkRed() {
		return colorDarkRed;
	}
	
	public Color getColorDarkGreen() {
		return colorDarkGreen;
	}
	
	public Color getColorDarkGoldenRod() {
		return colorDarkGoldenRod;
	}
	
	public Color getColorDarkSlateGray() {
		return colorDarkSlateGray;
	}
	
	public Color getMarkColor(Color color) {
		Color res = color;
		int r = res.getRed();
		int g = res.getGreen();
		int b = res.getBlue();
		boolean editable = false;
		if(r + 10 <= 255) {
			r += 10;
			editable = true;
		}
		if(g + 10 <= 255) {
			g += 10;
			editable = true;
		}
		if(b + 10 <= 255) {
			b += 10;
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
			return getOriginalIcon("/assets/img/r1080/gui/VerticalMap.png");
		else
			return getOriginalIcon("/assets/img/r720/gui/VerticalMap.png");
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
