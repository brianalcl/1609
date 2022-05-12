package games.dodgeWall.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import games.dodgeWall.logic.DodgeWallGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;


public class DodgeWallPanel extends GamePanel{
	
	protected boolean stopKey;
	protected DodgeWallGame game;
	
	public DodgeWallPanel(GUI gui) {
		super(gui, true);
		game = new DodgeWallGame(this);
		setBackground(this.gui.getImageFactory().getColorDefault());
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard3());
		stopKey = false;
		addControls();
	}
	
	protected void addControls() {
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(stopKey) {
					moveCenter();
					stopKey = false;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!stopKey && (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)) {
					moveUp();
					stopKey = true;
				}
				if(!stopKey && (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)) {
					moveDown();
					stopKey = true;
				}
			}
		});
	}
	
	private void moveCenter() {
		game.moveCenter();
	}
	
	private void moveUp() {
		
		game.moveUp();
	}

	private void moveDown() {
		game.moveDown();
	}
	
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}
	
	public void win() {
		//Never win
	}
	
	public void restart() {
		gui.setPanel(new DodgeWallPanel(gui));
	}
}
