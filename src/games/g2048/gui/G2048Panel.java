package games.g2048.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import games.g2048.logic.G2048Game;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;

public class G2048Panel extends GamePanel{
	
	protected G2048Game game;
	
	public G2048Panel(GUI gui) {
		super(gui);
		game = new G2048Game(this);
		setBackground(this.gui.getImageFactory().getColorDefault());
		lblKeyboard.setIcon(this.gui.getImageFactory().getKeyboard1());
		addControls();
	}

	@Override
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
		game.moveUp();
	}
	private void moveDown() {
		game.moveDown();
	}
	private void moveRight() {
		game.moveRight();
	}
	private void moveLeft() {
		game.moveLeft();
	}	
	
	@Override
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
		
	}

	@Override
	public void win() {
		//never win
		
	}

	@Override
	public void restart() {
		gui.setPanel(new G2048Panel(gui));
		
	}

}
