package games.shot.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.shot.logic.ShotGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;


public class ShotPanel extends GamePanel{
	
	protected ShotGame game;
	
	public ShotPanel(GUI gui) {
		super(gui, false);
		game = new ShotGame(this);
		setBackground(this.gui.getImageFactory().getColorDefault());
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard4());
		addControls();
	}
	
	protected void addControls() {
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
					moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					shot();
				}
			}
		});
	}
	
	private void moveLeft() {
		game.moveLeft();
	}

	private void moveRight() {
		game.moveRight();
	}
	
	private void shot() {
		game.shot();
	}
	
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}
	
	public void win() {
		//Never win
	}
	
	public void restart() {
		gui.setPanel(new ShotPanel(gui));
	}
}
