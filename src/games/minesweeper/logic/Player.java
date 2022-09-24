package games.minesweeper.logic;

import factory.Factory;

public class Player {
	
	protected MinesweeperMap map;
	protected Factory imageFactory;
	
	public Player(MinesweeperMap map, Factory imageFactory) {
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
