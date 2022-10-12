package games.piano.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.piano.logic.PianoGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.utilities.InternalBorder;


public class PianoPanel extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected PianoGame game;
	
	public PianoPanel(GUI gui) {
		super(gui, false);
		game = new PianoGame(this);
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
	
	protected void keyLeft() {
		game.left();
	}

	protected void keyRight() {
		game.right();
	}
	
	protected void keyCenter() {
		game.center();
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
		gui.setPanel(new PianoPanel(gui));
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
					if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
						keyCenter();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}
