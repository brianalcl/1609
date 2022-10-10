package games.collect.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.collect.logic.CollectGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;


public class CollectPanel extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected CollectGame game;
	
	public CollectPanel(GUI gui) {
		super(gui, false);
		game = new CollectGame(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard6());
	}
	
	protected void keyLeft() {
		game.moveLeft();
	}

	protected void keyRight() {
		game.moveRight();
	}
	
	@Override
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "FINISH", lblScore.getText(), lblTime.getText()));
	}
	
	@Override
	public void win() {
		//No win.
	}
	
	@Override
	public void restart() {
		gui.setPanel(new CollectPanel(gui));
	}
	
	@Override
	protected void addControls() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!game.isPause()) {
					if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
						keyLeft();
					}
					if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						keyRight();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
