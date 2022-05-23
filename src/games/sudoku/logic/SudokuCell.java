package games.sudoku.logic;

import general.logic.Cell;
import general.logic.Map;

public class SudokuCell extends Cell{
	
	protected int number;
	
	public SudokuCell(int row, int column, Map map) {
		super(row, column, map);
		this.number = 0;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
