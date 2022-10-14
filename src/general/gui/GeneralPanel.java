package general.gui;

import java.awt.Font;

import javax.swing.JPanel;

import factory.Factory;
import gui.GUI;

public abstract class GeneralPanel extends JPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected GUI gui;
	protected Font font;
	protected double scaleFactor;
	
	public GeneralPanel(GUI gui) {
		this.gui = gui;
		setSize(this.gui.getImageFactory().getScreenResolution());
		setLocation(0, 0);
		setLayout(null);
		scaleFactor = this.gui.getImageFactory().getScreenResolution().getHeight() / Factory.DEFAULT_HEIGHT;
		font = this.gui.getTheFont();
	}
}
