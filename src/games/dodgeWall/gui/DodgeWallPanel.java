package games.dodgeWall.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import games.dodgeWall.logic.DodgeWallGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;


public class DodgeWallPanel extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected boolean stopKey;
	protected DodgeWallGame game;
	
	public DodgeWallPanel(GUI gui) {
		super(gui, true);
		game = new DodgeWallGame(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard3());
		stopKey = false;
	}

	
	private void moveCenter() {
		game.moveCenter();
	}
	
	protected void keyUp() {
		
		game.moveUp();
	}

	protected void keyDown() {
		game.moveDown();
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
		gui.setPanel(new DodgeWallPanel(gui));
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
						moveCenter();
						stopKey = false;
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!game.isPause()) {
					if(!stopKey && (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)) {
						keyUp();
						stopKey = true;
					}
					if(!stopKey && (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)) {
						keyDown();
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
