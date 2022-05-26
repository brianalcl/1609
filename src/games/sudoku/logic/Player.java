package games.sudoku.logic;

import imageFactory.ImageFactory;

public class Player {
	
	protected SudokuMap map;
	protected ImageFactory imageFactory;
	
	public Player(SudokuMap map, ImageFactory imageFactory) {
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
