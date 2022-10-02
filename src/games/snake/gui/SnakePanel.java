package games.snake.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.snake.logic.SnakeGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.logic.Game;


public class SnakePanel extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected SnakeGame game;
	
	public SnakePanel(GUI gui) {
		super(gui, true);
		game = new SnakeGame(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard1());
	}
	
	protected void keyUp() {
		game.setDirection(Game.MOVE_UP);
	}

	protected void keyRight() {
		game.setDirection(Game.MOVE_RIGHT);
	}

	protected void keyDown() {
		game.setDirection(Game.MOVE_DOWN);
	}

	protected void keyLeft() {
		game.setDirection(Game.MOVE_LEFT);
	}
	
	@Override
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}
	
	@Override
	public void win() {
		gui.setPanel(new GameOverPanel(gui, this,"WIN", lblScore.getText(), lblTime.getText()));
	}
	
	@Override
	public void restart() {
		gui.setPanel(new SnakePanel(gui));
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
				if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
					keyUp();
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
			}
		});
	}
}
