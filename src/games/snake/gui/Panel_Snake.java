package games.snake.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.snake.logic.Game_Snake;
import general.gui.GamePanel;
import general.logic.Game;
import gui.GUI;
import gui.GameOverPanel;


public class Panel_Snake extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Snake game;
	
	public Panel_Snake(GUI gui) {
		super(gui, true);
		fileToSavePath = "7_save";
		game = new Game_Snake(this);
		load();
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard1());
		lblKeyboard.setVisible(true);
	}
	
	@Override
	public void lose() {
		save();
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}
	
	@Override
	public void win() {
		save();
		gui.setPanel(new GameOverPanel(gui, this,"WIN", lblScore.getText(), lblTime.getText()));
	}
	
	@Override
	public void restart() {
		gui.setPanel(new Panel_Snake(gui));
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
					if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
						game.operate(Game.MOVE_UP);
					}
					if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
						game.operate(Game.MOVE_DOWN);
					}
					if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
						game.operate(Game.MOVE_LEFT);
					}
					if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						game.operate(Game.MOVE_RIGHT);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
