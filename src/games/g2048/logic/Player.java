package games.g2048.logic;

import imageFactory.ImageFactory;

public class Player {
	
	protected G2048Map map;
	protected ImageFactory imageFactory;
	
	public Player(G2048Map map, ImageFactory imageFactory) {
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
