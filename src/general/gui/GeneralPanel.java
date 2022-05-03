package general.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

import imageFactory.DarkImageFactory;
import imageFactory.ImageFactory;

public abstract class GeneralPanel extends JPanel{
	protected GUI gui;
	protected Font font;
	protected double widthScaleFactor;
	protected double heightScaleFactor;
	
	public GeneralPanel(GUI gui) {
		this.gui = gui;
		setSize(gui.getImageFactory().getScreenResolution());
		setLocation(0, 0);
		setLayout(null);
		font = this.gui.getImageFactory().getFont();
		this.widthScaleFactor = this.gui.getImageFactory().getScreenResolution().getWidth() / ImageFactory.DEFAULT_WIDTH;
		this.heightScaleFactor = this.gui.getImageFactory().getScreenResolution().getHeight() / ImageFactory.DEFAULT_HEIGHT;
	}
}
