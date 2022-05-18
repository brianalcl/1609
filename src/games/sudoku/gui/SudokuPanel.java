package games.sudoku.gui;

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
