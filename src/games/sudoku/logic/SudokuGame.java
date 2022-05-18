package games.sudoku.logic;

import games.sudoku.gui.SudokuPanel;
import general.logic.Game;

public class SudokuGame extends Game{
	
	protected Player player;
	
	public SudokuGame(SudokuPanel panel) {
		super(panel);
		this.player = new Player(new SudokuMap(this), this.panel.getImageFactory());
	}
	
	public void lose() {
		super.lose();
	}
	
	public void win() {
		super.win();
	}
}
