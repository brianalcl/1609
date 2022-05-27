package games.sudoku.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import games.sudoku.logic.SudokuCell;
import games.sudoku.logic.SudokuGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;

public class SudokuPanel extends GamePanel{
	
	protected SudokuGame game;
	
	public SudokuPanel(GUI gui) {
		super(gui, false);
		game = new SudokuGame(this);
		setBackground(this.gui.getImageFactory().getColorDefault());
		lblKeyboard.setIcon(this.gui.getImageFactory().getKeyboard1());
		addControls();
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
