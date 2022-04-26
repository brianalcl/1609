package gui;
import java.awt.Color;
import javax.swing.JPanel;

import gui.games.snake.SnakePanel;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class InitialPanel extends GeneralPanel{
	public InitialPanel(GUI gui) {
		super(gui);
		setBackground(Color.DARK_GRAY);
		JButton btnNewButton = new JButton("Snake");
		btnNewButton.setBounds(10, 11, 80, 60);
		add(btnNewButton);
		btnNewButton.addActionListener(e -> startSnake());
	}
	private void startSnake() {
		gui.setPanel(new SnakePanel(this.gui));
	}
}
