package games.piano.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.piano.logic.Game_Piano;
import general.gui.GamePanel;
import general.logic.Game;
import general.utilities.InternalBorder;
import gui.GUI;
import gui.GameOverPanel;


public class Panel_Piano extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Piano game;
	
	public Panel_Piano(GUI gui) {
		super(gui, false);
		game = new Game_Piano(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard7());
		putBorder();
	}
	
	private void putBorder() {
		int borderSize = (int) Math.round(3 * scaleFactor);
		
		for(int r = 0; r < 16; r++) {
			matrix[r][2].setBorder(new InternalBorder(0, borderSize, 0, 0, game.getImageFactory().getColorDefault()));
			matrix[r][3].setBorder(new InternalBorder(0, 0, 0, borderSize, game.getImageFactory().getColorDefault()));
			
			matrix[r][5].setBorder(new InternalBorder(0, borderSize, 0, 0, game.getImageFactory().getColorDefault()));
			matrix[r][6].setBorder(new InternalBorder(0, 0, 0, borderSize, game.getImageFactory().getColorDefault()));
		}
		
		for(int c = 0; c < 9; c++) {
			matrix[0][c].setBorder(new InternalBorder(borderSize, 0, 0, 0, game.getImageFactory().getColorDefault()));
			matrix[1][c].setBorder(new InternalBorder(0, 0, borderSize, 0, game.getImageFactory().getColorDefault()));
		}
		
		matrix[0][2].setBorder(new InternalBorder(borderSize, borderSize, 0, 0, game.getImageFactory().getColorDefault()));
		matrix[0][3].setBorder(new InternalBorder(borderSize, 0, 0, borderSize, game.getImageFactory().getColorDefault()));
		
		matrix[0][5].setBorder(new InternalBorder(borderSize, borderSize, 0, 0, game.getImageFactory().getColorDefault()));
		matrix[0][6].setBorder(new InternalBorder(borderSize, 0, 0, borderSize, game.getImageFactory().getColorDefault()));
		
		matrix[1][2].setBorder(new InternalBorder(0, borderSize, borderSize, 0, game.getImageFactory().getColorDefault()));
		matrix[1][3].setBorder(new InternalBorder(0, 0, borderSize, borderSize, game.getImageFactory().getColorDefault()));
		
		matrix[1][5].setBorder(new InternalBorder(0, borderSize, borderSize, 0, game.getImageFactory().getColorDefault()));
		matrix[1][6].setBorder(new InternalBorder(0, 0, borderSize, borderSize, game.getImageFactory().getColorDefault()));
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
		gui.setPanel(new Panel_Piano(gui));
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
					if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
						game.operate(Game.MOVE_CENTER);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
