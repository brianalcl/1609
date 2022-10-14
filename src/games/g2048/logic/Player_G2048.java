package games.g2048.logic;

import factory.Factory;
import general.sound.Sound;

public class Player_G2048 {
	
	protected Map_G2048 map;
	protected Factory imageFactory;
	
	public Player_G2048(Map_G2048 map, Factory imageFactory) {
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
