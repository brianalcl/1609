package gui.games.snake;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import gui.GUI;
import gui.GeneralGamePanel;
import game.Game;
import game.titles.SnakeGame;


public class SnakePanel extends GeneralGamePanel{
	
	protected SnakeGame game;
	
	public SnakePanel(GUI gui) {
		super(gui);
		game = new SnakeGame(this);
		setBackground(new Color(0, 80, 80));
		addControls();
	}
	
	private void addControls() {
		Action moveUp = new AbstractAction() {
			
	
			@Override
			public void actionPerformed(ActionEvent e) {
				moveUp();
			}
		};
		
		Action moveDown = new AbstractAction() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveDown();
			}
		};
		
		Action moveRight = new AbstractAction() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveRight();
			}
		};
		
		Action moveLeft = new AbstractAction() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveLeft();
			}
		};
		
		
		final String up		= "up";
		final String down		= "down";
		final String right	= "right";
		final String left	= "left";
		
		InputMap iMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		iMap.put(KeyStroke.getKeyStroke("UP"),		up);
		iMap.put(KeyStroke.getKeyStroke("W"),		up);
		iMap.put(KeyStroke.getKeyStroke("DOWN"),	down);
		iMap.put(KeyStroke.getKeyStroke("S"),		down);
		iMap.put(KeyStroke.getKeyStroke("RIGHT"),	right);
		iMap.put(KeyStroke.getKeyStroke("D"),		right);
		iMap.put(KeyStroke.getKeyStroke("LEFT"),	left);
		iMap.put(KeyStroke.getKeyStroke("A"),		left);
		
		getActionMap().put(up,		moveUp);
		getActionMap().put(down,		moveDown);
		getActionMap().put(right,		moveRight);
		getActionMap().put(left,	moveLeft);
	}
	
	private void moveUp() {
		game.setDirection(Game.MOVE_UP);
	}

	private void moveRight() {
		game.setDirection(Game.MOVE_RIGHT);
	}

	private void moveDown() {
		game.setDirection(Game.MOVE_DOWN);
	}

	private void moveLeft() {
		game.setDirection(Game.MOVE_LEFT);
	}
}
