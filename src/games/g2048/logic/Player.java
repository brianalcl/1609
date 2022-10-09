package games.g2048.logic;

import factory.Factory;
import general.sound.Sound;

public class Player {
	
	protected G2048Map map;
	protected Factory imageFactory;
	
	public Player(G2048Map map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}

	public void moveUp() {
		Sound.getInstance().moveSound();
		map.moveUp();
	}

	public void moveDown() {
		Sound.getInstance().moveSound();
		map.moveDown();
		
	}

	public void moveRight() {
		Sound.getInstance().moveSound();
		map.moveRight();
	}

	public void moveLeft() {
		Sound.getInstance().moveSound();
		map.moveLeft();
	}

}
