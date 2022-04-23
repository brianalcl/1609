package gui;

import javax.swing.JPanel;

public abstract class GeneralPanel extends JPanel{
	protected GUI gui;
	public GeneralPanel(GUI gui) {
		this.gui = gui;
		setSize(gui.getImageFactory().getScreenResolution());
		setLocation(0, 0);
		setLayout(null);
	}
}
