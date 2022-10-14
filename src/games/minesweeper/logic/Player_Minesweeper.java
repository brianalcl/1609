package games.minesweeper.logic;

import factory.Factory;

public class Player_Minesweeper {
	
	protected Map_Minesweeper map;
	protected Factory imageFactory;
	
	public Player_Minesweeper(Map_Minesweeper map, Factory imageFactory) {
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
