package games.minesweeper.logic;

import abstractFactory.AbstractFactory;

public class Player_Minesweeper {
	
	protected Map_Minesweeper map;
	protected AbstractFactory imageFactory;
	
	public Player_Minesweeper(Map_Minesweeper map, AbstractFactory imageFactory) {
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
