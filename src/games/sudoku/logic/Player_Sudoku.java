package games.sudoku.logic;

import abstractFactory.AbstractFactory;

public class Player_Sudoku {
	
	protected Map_Sudoku map;
	protected AbstractFactory imageFactory;
	
	public Player_Sudoku(Map_Sudoku map, AbstractFactory imageFactory) {
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
