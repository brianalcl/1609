package gui;

import javax.swing.JPanel;

public abstract class GeneralPanel extends JPanel{
	protected GUI gui;
	public GeneralPanel(GUI gui) {
		this.gui = gui;
		setBounds(0, 0, 1280, 720);
		setLayout(null);
	}
}
