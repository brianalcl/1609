package games.dodgeWall.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import games.dodgeWall.logic.Game_DodgeWall;
import general.gui.GamePanel;
import general.logic.Game;
import gui.GUI;
import gui.GameOverPanel;


public class Panel_DodgeWall extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected boolean stopKey;
	protected Game_DodgeWall game;
	
	public Panel_DodgeWall(GUI gui) {
		super(gui, true);
		game = new Game_DodgeWall(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard3());
		stopKey = false;
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
		gui.setPanel(new Panel_DodgeWall(gui));
	}
	
	@Override
	protected void addControls() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(!game.isPause()) {
					if(stopKey) {
						game.operate(Game.MOVE_CENTER);
						stopKey = false;
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!game.isPause()) {
					
					if(!stopKey && (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)) {
						game.operate(Game.MOVE_UP);
						stopKey = true;
					}
					if(!stopKey && (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)) {
						game.operate(Game.MOVE_DOWN);
						stopKey = true;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
