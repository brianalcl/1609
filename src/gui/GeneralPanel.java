package gui;

import javax.swing.JPanel;

public abstract class GeneralPanel extends JPanel{
	protected GUI gui;
	public GeneralPanel(GUI gui) {
		this.gui = gui;
		//setSize(gui.getImageFactory().getScreenResolution()); TODO
		setSize(1280, 720);
		setLocation(0, 0);
		setLayout(null);
	}
}
