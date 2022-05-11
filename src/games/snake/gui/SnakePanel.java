package games.snake.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import games.snake.logic.SnakeGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.logic.Game;


public class SnakePanel extends GamePanel{
	
	protected SnakeGame game;
	
	public SnakePanel(GUI gui) {
		super(gui);
		game = new SnakeGame(this);
		setBackground(this.gui.getImageFactory().getColorDefault());
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard1());
		addControls();
	}
	
	protected void addControls() {
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
	
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}
	
	public void win() {
		gui.setPanel(new GameOverPanel(gui, this,"WIN", lblScore.getText(), lblTime.getText()));
	}
	
	public void restart() {
		gui.setPanel(new SnakePanel(gui));
	}
}
