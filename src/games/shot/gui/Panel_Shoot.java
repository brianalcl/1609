package games.shot.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.shot.logic.Game_Shoot;
import general.gui.GamePanel;
import general.logic.Game;
import gui.GUI;
import gui.GameOverPanel;


public class Panel_Shoot extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Shoot game;
	
	public Panel_Shoot(GUI gui) {
		super(gui, false);
		fileToSavePath = "6_save";
		game = new Game_Shoot(this);
		load();
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard4());
	}
	
	@Override
	public void lose() {
		save();
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
	public String getFileToSavePath() {
		return fileToSavePath;
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
						game.operate(Game.MOVE_LEFT);
					}
					if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						game.operate(Game.MOVE_RIGHT);
					}
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						game.operate(Game.SPACE);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
