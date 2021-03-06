package games.sudoku.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import games.sudoku.logic.SudokuGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.utilities.LateralBorder;

public class SudokuPanel extends GamePanel{
	
	protected SudokuGame game;
	
	public SudokuPanel(GUI gui) {
		super(gui, false);
		game = new SudokuGame(this);
		setBackground(this.gui.getImageFactory().getColorDefault());
		lblKeyboard.setIcon(this.gui.getImageFactory().getKeyboard5());
		lblMouse.setIcon(gui.getImageFactory().getMouse());
		putBorder();
		addControls();
	}
	
	private void putBorder() {
		Color colorBorder = getBackground().darker().darker();
		
		for(int r = 7; r < 16; r++) {
			for(int c = 0; c < 9; c++) {
				matrix[r][c].setBorder(new LateralBorder(1,1,1,1, colorBorder));
				if(r == 9 || r == 12)
					matrix[r][c].setBorder(new LateralBorder(2,1,1,1, colorBorder));
				if(r == 10 || r == 13)
					matrix[r][c].setBorder(new LateralBorder(1,1,2,1, colorBorder));
				if(c == 2 || c == 5)
					matrix[r][c].setBorder(new LateralBorder(1,2,1,1, colorBorder));
				if(c == 3 || c == 6)
					matrix[r][c].setBorder(new LateralBorder(1,1,1,2, colorBorder));
			}
		}
		matrix[9][2].setBorder(new LateralBorder(2,2,1,1, colorBorder));
		matrix[10][2].setBorder(new LateralBorder(1,2,2,1, colorBorder));
		matrix[9][3].setBorder(new LateralBorder(2,1,1,2, colorBorder));
		matrix[10][3].setBorder(new LateralBorder(1,1,2,2, colorBorder));
		
		matrix[9][5].setBorder(new LateralBorder(2,2,1,1, colorBorder));
		matrix[10][5].setBorder(new LateralBorder(1,2,2,1, colorBorder));
		matrix[9][6].setBorder(new LateralBorder(2,1,1,2, colorBorder));
		matrix[10][6].setBorder(new LateralBorder(1,1,2,2, colorBorder));
		
		matrix[12][2].setBorder(new LateralBorder(2,2,1,1, colorBorder));
		matrix[13][2].setBorder(new LateralBorder(1,2,2,1, colorBorder));
		matrix[12][3].setBorder(new LateralBorder(2,1,1,2, colorBorder));
		matrix[13][3].setBorder(new LateralBorder(1,1,2,2, colorBorder));
		
		matrix[12][5].setBorder(new LateralBorder(2,2,1,1, colorBorder));
		matrix[13][5].setBorder(new LateralBorder(1,2,2,1, colorBorder));
		matrix[12][6].setBorder(new LateralBorder(2,1,1,2, colorBorder));
		matrix[13][6].setBorder(new LateralBorder(1,1,2,2, colorBorder));
	}
	
	@Override
	public void changeCell(JLabel graphicCell, int row, int column) {
		matrix[row][column].setIcon(graphicCell.getIcon());
		matrix[row][column].setBackground(graphicCell.getBackground());
		matrix[row][column].setText(graphicCell.getText());
	}
	
	@Override
	protected void addControls() {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.click(e.getX()/(panel.getWidth()/9), e.getY()/(panel.getHeight()/16));
			}
		});
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				switch (e.getKeyChar()) {
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
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}

	@Override
	public void win() {
		gui.setPanel(new GameOverPanel(gui, this, "WIN", lblScore.getText(), lblTime.getText()));
	}

	@Override
	public void restart() {
		gui.setPanel(new SudokuPanel(gui));
		
	}


}
