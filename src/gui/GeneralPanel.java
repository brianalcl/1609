package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

public abstract class GeneralPanel extends JPanel{
	protected GUI gui;
	protected Font font;
	
	public GeneralPanel(GUI gui) {
		this.gui = gui;
		//setSize(gui.getImageFactory().getScreenResolution());
		setSize(1280, 720);
		setLocation(0, 0);
		setLayout(null);
		//font = gui.getImageFactory().getFont();
		
		try {
			InputStream is =  getClass().getResourceAsStream("/res/font/futurespore.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (IOException | FontFormatException ex) {
			System.out.println("ERROR: FONT NOT FOUND");
		}
		
	}
}
