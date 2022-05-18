package games.sudoku.logic;

import imageFactory.ImageFactory;

public class Player {
	
	protected SudokuMap map;
	protected ImageFactory imageFactory;
	
	public Player(SudokuMap map, ImageFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}


}
