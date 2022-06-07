package games.minesweeper.logic;

import imageFactory.ImageFactory;

public class Player {
	
	protected MinesweeperMap map;
	protected ImageFactory imageFactory;
	
	public Player(MinesweeperMap map, ImageFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}

	public void click(int row, int column) {
		map.click(row, column);
	}
	
	public void putFlag(int row, int column) {
		map.putFlag(row, column);
	}

}
