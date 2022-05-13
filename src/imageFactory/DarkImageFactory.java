package imageFactory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;

public class DarkImageFactory extends ImageFactory{
	private Icon squircle;
	private Icon emptyNumberIcon;
	private Icon icon_0;
	private Icon icon_1;
	private Icon icon_2;
	private Icon icon_3;
	private Icon icon_4;
	private Icon icon_5;
	private Icon icon_6;
	private Icon icon_7;
	private Icon icon_8;
	private Icon icon_9;
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
	
	public DarkImageFactory(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		
		
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
		colorDefault = colorDarkSlateGray;
		createIcons();
	}
	
	@Override
	public void setScreenResolution(Dimension d) {
		super.setScreenResolution(d);
		createIcons();
	}

	private void createIcons() {
		if(screenHeight == DEFAULT_HEIGHT) {
			squircle = getOriginalIcon("/assets/img/r1080/gameImages/squircle1080.png");
			emptyNumberIcon = getOriginalIcon("/assets/img/r1080/gameImages/emptyNumber1080.png");
			icon_0 = getOriginalIcon("/assets/img/r1080/gameImages/0-1080.png");
			icon_1 = getOriginalIcon("/assets/img/r1080/gameImages/1-1080.png");
			icon_2 = getOriginalIcon("/assets/img/r1080/gameImages/2-1080.png");
			icon_3 = getOriginalIcon("/assets/img/r1080/gameImages/3-1080.png");
			icon_4 = getOriginalIcon("/assets/img/r1080/gameImages/4-1080.png");
			icon_5 = getOriginalIcon("/assets/img/r1080/gameImages/5-1080.png");
			icon_6 = getOriginalIcon("/assets/img/r1080/gameImages/6-1080.png");
			icon_7 = getOriginalIcon("/assets/img/r1080/gameImages/7-1080.png");
			icon_8 = getOriginalIcon("/assets/img/r1080/gameImages/8-1080.png");
			icon_9 = getOriginalIcon("/assets/img/r1080/gameImages/9-1080.png");
		}
		else {
			squircle = getOriginalIcon("/assets/img/r720/gameImages/squircle720.png");
			emptyNumberIcon = getOriginalIcon("/assets/img/r720/gameImages/emptyNumber720.png");
			icon_0 = getOriginalIcon("/assets/img/r720/gameImages/0-720.png");
			icon_1 = getOriginalIcon("/assets/img/r720/gameImages/1-720.png");
			icon_2 = getOriginalIcon("/assets/img/r720/gameImages/2-720.png");
			icon_3 = getOriginalIcon("/assets/img/r720/gameImages/3-720.png");
			icon_4 = getOriginalIcon("/assets/img/r720/gameImages/4-720.png");
			icon_5 = getOriginalIcon("/assets/img/r720/gameImages/5-720.png");
			icon_6 = getOriginalIcon("/assets/img/r720/gameImages/6-720.png");
			icon_7 = getOriginalIcon("/assets/img/r720/gameImages/7-720.png");
			icon_8 = getOriginalIcon("/assets/img/r720/gameImages/8-720.png");
			icon_9 = getOriginalIcon("/assets/img/r720/gameImages/9-720.png");
		}
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
	
	public Icon getKeyboard3() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/keyboard3-1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/keyboard3-720.png");
	}	
	
	public Icon getMouse() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/mouse1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/mouse720.png");
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
	
	public Icon getConfiguration() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/menuIcons/Configuration1080.png");
		else
			return getOriginalIcon("/assets/img/r720/menuIcons/Configuration720.png");
	}
	
	public Icon getMapHorizontal() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/mapHorizontal1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/mapHorizontal720.png");
	}
	
	public Icon getMapVertical() {
		if(screenHeight == DEFAULT_HEIGHT)
			return getOriginalIcon("/assets/img/r1080/gameImages/mapVertical1080.png");
		else
			return getOriginalIcon("/assets/img/r720/gameImages/mapVertical720.png");
	}	
	
	public Icon getEmpty() {
		return null;
	}

	public Icon getEmptyNumber() {
		return emptyNumberIcon;
	}
	
	@Override
	public Icon getSquircle() {
		return squircle;
	}

	@Override
	public Icon get0() {
		return icon_0;
	}

	@Override
	public Icon get1() {
		return icon_1;
	}

	@Override
	public Icon get2() {
		return icon_2;
	}

	@Override
	public Icon get3() {
		return icon_3;
	}

	@Override
	public Icon get4() {
		return icon_4;
	}

	@Override
	public Icon get5() {
		return icon_5;
	}

	@Override
	public Icon get6() {
		return icon_6;
	}

	@Override
	public Icon get7() {
		return icon_7;
	}

	@Override
	public Icon get8() {
		return icon_8;
	}

	@Override
	public Icon get9() {
		return icon_9;
	}

}
