package games.g2048.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import games.g2048.logic.Game_G2048;
import general.gui.GamePanel;
import general.logic.Game;
import general.utilities.InternalBorder;
import gui.GUI;
import gui.GameOverPanel;

public class Panel_G2048 extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_G2048 game;
	
	public Panel_G2048(GUI gui) {
		super(gui, true);
		game = new Game_G2048(this);
		lblKeyboard.setIcon(this.gui.getImageFactory().getKeyboard1());
		putBorder();
	}
	
	private void putBorder() {
		Color colorBorder = gui.getImageFactory().getColorDefault();
		colorBorder = gui.getImageFactory().getMarkColor(colorBorder, -20);
		int borderSize = (int) Math.round(3 * scaleFactor);
		
		for(int r = 2; r < 9; r += 2) {
			for(int c = 3; c < 14; c += 3) {
				matrix[r][c].setBorder(new InternalBorder(borderSize, 0, 0, 0, colorBorder));
				matrix[r][c-1].setBorder(new InternalBorder(borderSize, 0, 0, borderSize, colorBorder));
				matrix[r][c+1].setBorder(new InternalBorder(borderSize, borderSize, 0, 0, colorBorder));
				
				matrix[r-1][c].setBorder(new InternalBorder(0, 0, borderSize, 0, colorBorder));
				matrix[r-1][c-1].setBorder(new InternalBorder(0, 0, borderSize, borderSize, colorBorder));
				matrix[r-1][c+1].setBorder(new InternalBorder(0, borderSize, borderSize, 0, colorBorder));
			}
		}
		
	}
	
	@Override
	public void changeCell(JLabel graphicCell, int row, int column) {
		super.changeCell(graphicCell, row, column);
		matrix[row][column].setText(graphicCell.getText());
		matrix[row][column].setForeground(graphicCell.getForeground());
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
		gui.setPanel(new Panel_G2048(gui));
		
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
