package games.sudoku.logic;

import games.sudoku.gui.SudokuPanel;
import general.logic.Game;

public class SudokuGame extends Game{
	
	protected Player player;
	protected SudokuPanel panel;
	
	public SudokuGame(SudokuPanel panel) {
		super(panel);
		this.panel = panel;
		this.player = new Player(new SudokuMap(this), this.panel.getImageFactory());
	}
	
	public void lose() {
		super.lose();
	}
	
	public void win() {
		super.win();
	}

	public void click(int x, int y) {
		int row = Math.abs((y - 15)%16);
		int column = x;
		player.click(row, column);
	}

	public void put(int n) {
		player.put(n);
		
	}

}
