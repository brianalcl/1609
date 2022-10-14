package games.shot.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.shot.logic.Game_Shoot;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;


public class Panel_Shoot extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Shoot game;
	
	public Panel_Shoot(GUI gui) {
		super(gui, false);
		game = new Game_Shoot(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard4());
	}
	
	protected void keyLeft() {
		game.moveLeft();
	}

	protected void keyRight() {
		game.moveRight();
	}
	
	protected void keySpace() {
		game.shot();
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
		gui.setPanel(new Panel_Shoot(gui));
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
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						keySpace();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
