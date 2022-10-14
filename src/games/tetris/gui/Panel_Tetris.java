package games.tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.tetris.logic.Game_Tetris;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.logic.Game;

public class Panel_Tetris extends GamePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Tetris game;

	public Panel_Tetris(GUI gui) {
		super(gui, false);
		game = new Game_Tetris(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard1());
	}

	protected void keyRight() {
		game.operate(Game.MOVE_RIGHT);
	}

	protected void keyDown() {
		game.operate(Game.MOVE_DOWN);
	}

	protected void keyLeft() {
		game.operate(Game.MOVE_LEFT);
	}	
	
	private void keyRotateLeft() {
		game.operate(Game.ROTATE_LEFT);
	}
	
	private void keyRotateRight() {
		game.operate(Game.ROTATE_RIGHT);
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
		gui.setPanel(new Panel_Tetris(gui));
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
					if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
						keyRotateLeft();
					}
					if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
						keyDown();
					}
					if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
						keyLeft();
					}
					if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						keyRight();
					}
					if(e.getKeyCode() == KeyEvent.VK_X) {
						keyRotateLeft();
					}
					if(e.getKeyCode() == KeyEvent.VK_Z) {
						keyRotateRight();
					}

				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}

}
