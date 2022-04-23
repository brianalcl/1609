package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.games.snake.SnakePanel;

public class GeneralGamePanel extends GeneralPanel{
	public GeneralGamePanel(GUI gui) {
		super(gui);
		JLabel lbl = new JLabel("");
		lbl.setSize(gui.getImageFactory().getScreenResolution());
		lbl.setIcon(gui.getImageFactory().getMap());
		add(lbl);
	}
}
