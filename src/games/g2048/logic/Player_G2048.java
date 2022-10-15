package games.g2048.logic;

import factory.Factory;

public class Player_G2048 {
	
	protected Map_G2048 map;
	protected Factory imageFactory;
	
	public Player_G2048(Map_G2048 map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}

	public void moveUp() {
		map.moveUp();
	}

	public void moveDown() {
		map.moveDown();
		
	}

	public void moveRight() {
		map.moveRight();
	}

	public void moveLeft() {
		map.moveLeft();
	}

}
