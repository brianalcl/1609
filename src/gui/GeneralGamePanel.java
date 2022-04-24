package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.Game;
import gui.games.snake.SnakePanel;

public class GeneralGamePanel extends GeneralPanel{
	
	protected Game game;
	
	public GeneralGamePanel(GUI gui) {
		super(gui);
		JLabel lbl = new JLabel("");
		lbl.setSize(gui.getImageFactory().getScreenResolution());
		lbl.setIcon(gui.getImageFactory().getMap());
		add(lbl);
	}

	public void setPoints(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTime(String res) {
		// TODO Auto-generated method stub
		
	}

	public void setLevel(String string) {
		// TODO Auto-generated method stub
		
	}
}
