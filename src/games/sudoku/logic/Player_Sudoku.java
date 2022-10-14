package games.sudoku.logic;

import factory.Factory;

public class Player_Sudoku {
	
	protected Map_Sudoku map;
	protected Factory imageFactory;
	
	public Player_Sudoku(Map_Sudoku map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}

	public void click(int row, int column) {
		map.click(row, column);
	}

	public void put(int n) {
		map.put(n);
	}


}
