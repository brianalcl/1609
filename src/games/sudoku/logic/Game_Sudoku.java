package games.sudoku.logic;

import games.sudoku.gui.Panel_Sudoku;
import general.logic.Game;

public class Game_Sudoku extends Game{
	
	protected Player_Sudoku player;
	
	public Game_Sudoku(Panel_Sudoku sudokuPanel) {
		super(sudokuPanel);
		this.player = new Player_Sudoku(new Map_Sudoku(this), this.panel.getImageFactory());
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
