package factory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;

public class ColorfulFactory extends Factory{
	private Icon capsule;
	private Icon square;
	private Icon triangle;
	private Icon circle;
	
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
		capsule = getTheIcon("/assets/img/r1080/gameImages/common/capsule.png");
		square = getTheIcon("/assets/img/r1080/gameImages/common/square.png");
		triangle = getTheIcon("/assets/img/r1080/gameImages/common/triangle.png");
		circle = getTheIcon("/assets/img/r1080/gameImages/common/circle.png");
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
		return getTheIcon("/assets/img/r1080/gameIcons/"+name+".png");
	}

	public Icon getKeyboard0() {
		return getTheIcon("/assets/img/r1080/gui/keyboard0.png");
	}

	public Icon getKeyboard1() {
		return getTheIcon("/assets/img/r1080/gui/keyboard1.png");
	}

	public Icon getKeyboard2() {
		return getTheIcon("/assets/img/r1080/gui/keyboard2.png");
	}	

	public Icon getKeyboard3() {
		return getTheIcon("/assets/img/r1080/gui/keyboard3.png");
	}	

	public Icon getKeyboard4() {
		return getTheIcon("/assets/img/r1080/gui/keyboard4.png");
	}	

	public Icon getKeyboard5() {
		return getTheIcon("/assets/img/r1080/gui/keyboard5.png");
	}

	public Icon getMouse() {
		return getTheIcon("/assets/img/r1080/gui/mouse.png");
	}

	public Icon getRestart() {
		return getTheIcon("/assets/img/r1080/gui/restart.png");
	}

	public Icon getHome() {
		return getTheIcon("/assets/img/r1080/gui/home.png");
	}

	public Icon getExit() {
		return getTheIcon("/assets/img/r1080/gui/exit.png");
	}

	public Icon getConfiguration() {
		return getTheIcon("/assets/img/r1080/gui/configuration.png");
	}

	public Icon getHorizontalMap() {
		return getTheIcon("/assets/img/r1080/gui/horizontalMap.png");
	}

	public Icon getVerticalMap() {
		return getTheIcon("/assets/img/r1080/gui/verticalMap.png");
	}	

	public Icon getEmpty() {
		return null;
	}
	
	public Icon getCapsule() {
		return capsule;
	}	
	
	public Icon getSquare() {
		return square;
	}
	
	public Icon getTriangle() {
		return triangle;
	}
	
	public Icon getCircle() {
		return circle;
	}

}
