package games.sudoku.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import games.sudoku.logic.Game_Sudoku;
import general.gui.GamePanel;
import general.utilities.InternalBorder;
import gui.GUI;
import gui.GameOverPanel;

public class Panel_Sudoku extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Sudoku game;
	
	public Panel_Sudoku(GUI gui) {
		super(gui, false);
		fileToSavePath = "8_save";
		game = new Game_Sudoku(this);
		load();
		lblKeyboard.setIcon(this.gui.getImageFactory().getKeyboard5());
		lblMouse.setIcon(gui.getImageFactory().getMouse());
		putBorder();
	}
	
	private void putBorder() {
		Color colorBorder = gui.getImageFactory().getColorDefault();
		int borderSize_1 = (int) Math.round(2 * scaleFactor);
		int borderSize_2 = (int) Math.round(3 * scaleFactor);
		
		for(int r = 7; r < 16; r++) {
			for(int c = 0; c < 9; c++) {
				matrix[r][c].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_1, borderSize_1, colorBorder));
				if(r == 9 || r == 12)
					matrix[r][c].setBorder(new InternalBorder(borderSize_2, borderSize_1 ,borderSize_1, borderSize_1, colorBorder));
				if(r == 10 || r == 13)
					matrix[r][c].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_2, borderSize_1, colorBorder));
				if(c == 2 || c == 5)
					matrix[r][c].setBorder(new InternalBorder(borderSize_1, borderSize_2, borderSize_1, borderSize_1, colorBorder));
				if(c == 3 || c == 6)
					matrix[r][c].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_1, borderSize_2, colorBorder));
			}
		}
		
		matrix[9][2].setBorder(new InternalBorder(borderSize_2, borderSize_2, borderSize_1, borderSize_1, colorBorder));
		matrix[10][2].setBorder(new InternalBorder(borderSize_1, borderSize_2, borderSize_2, borderSize_1, colorBorder));
		matrix[9][3].setBorder(new InternalBorder(borderSize_2, borderSize_1, borderSize_1, borderSize_2, colorBorder));
		matrix[10][3].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_2, borderSize_2, colorBorder));
		
		matrix[9][5].setBorder(new InternalBorder(borderSize_2, borderSize_2, borderSize_1, borderSize_1, colorBorder));
		matrix[10][5].setBorder(new InternalBorder(borderSize_1, borderSize_2, borderSize_2, borderSize_1, colorBorder));
		matrix[9][6].setBorder(new InternalBorder(borderSize_2, borderSize_1, borderSize_1, borderSize_2, colorBorder));
		matrix[10][6].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_2, borderSize_2, colorBorder));
		
		matrix[12][2].setBorder(new InternalBorder(borderSize_2, borderSize_2, borderSize_1, borderSize_1, colorBorder));
		matrix[13][2].setBorder(new InternalBorder(borderSize_1, borderSize_2, borderSize_2, borderSize_1, colorBorder));
		matrix[12][3].setBorder(new InternalBorder(borderSize_2, borderSize_1, borderSize_1, borderSize_2, colorBorder));
		matrix[13][3].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_2, borderSize_2, colorBorder));
		
		matrix[12][5].setBorder(new InternalBorder(borderSize_2, borderSize_2, borderSize_1, borderSize_1, colorBorder));
		matrix[13][5].setBorder(new InternalBorder(borderSize_1, borderSize_2, borderSize_2, borderSize_1, colorBorder));
		matrix[12][6].setBorder(new InternalBorder(borderSize_2, borderSize_1, borderSize_1, borderSize_2, colorBorder));
		matrix[13][6].setBorder(new InternalBorder(borderSize_1, borderSize_1, borderSize_2, borderSize_2, colorBorder));
		
		matrix[5][2].setBorder(new InternalBorder(borderSize_2, 0, borderSize_2, borderSize_2, colorBorder));
		matrix[5][3].setBorder(new InternalBorder(borderSize_2, 0, borderSize_2, 0, colorBorder));
		matrix[5][4].setBorder(new InternalBorder(borderSize_2, 0, borderSize_2, 0, colorBorder));
		matrix[5][5].setBorder(new InternalBorder(borderSize_2, 0, borderSize_2, 0, colorBorder));
		matrix[5][6].setBorder(new InternalBorder(borderSize_2, borderSize_2, borderSize_2, 0, colorBorder));
	}

	
	@Override
	public void changeCell(JLabel graphicCell, int row, int column) {
		super.changeCell(graphicCell, row, column);
		matrix[row][column].setText(graphicCell.getText());
	}
	
	@Override
	public void lose() {
		//No lose.
	}

	@Override
	public void win() {
		save();
		gui.setPanel(new GameOverPanel(gui, this, "WIN", lblScore.getText(), lblTime.getText()));
	}

	@Override
	public void restart() {
		gui.setPanel(new Panel_Sudoku(gui));
		
	}
	
	@Override
	public String getFileToSavePath() {
		return fileToSavePath;
	}
	
	@Override
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
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
				if(!game.isPause()) { 
					switch (e.getKeyCode()) {
					case KeyEvent.VK_1:
						game.put(1);
						break;
					case KeyEvent.VK_2:
						game.put(2);
						break;
					case KeyEvent.VK_3:
						game.put(3);
						break;
					case KeyEvent.VK_4:
						game.put(4);
						break;
					case KeyEvent.VK_5:
						game.put(5);
						break;
					case KeyEvent.VK_6:
						game.put(6);
						break;
					case KeyEvent.VK_7:
						game.put(7);
						break;
					case KeyEvent.VK_8:
						game.put(8);
						break;
					case KeyEvent.VK_9:
						game.put(9);
						break;
					case KeyEvent.VK_0:
						game.put(0);
						break;
					default:
						break;
					}
				}
			}
		});
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!game.isPause()) {
					game.click(e.getX()/(panel.getWidth()/9), e.getY()/(panel.getHeight()/16));
				}
			}
		});
	}
}
