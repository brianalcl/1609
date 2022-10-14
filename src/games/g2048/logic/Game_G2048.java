package games.g2048.logic;

import games.g2048.gui.Panel_G2048;
import general.logic.Game;

public class Game_G2048 extends Game{
	
	protected Player_G2048 player;
	
	public Game_G2048(Panel_G2048 panel) {
		super(panel);
		this.player = new Player_G2048(new Map_G2048(this), this.panel.getImageFactory());
	}

	public void moveUp() {
		player.moveUp();
	}

	public void moveDown() {
		player.moveDown();
		
	}

	public void moveRight() {
		player.moveRight();
	}

	public void moveLeft() {
		player.moveLeft();
	}
	
	public void lose() {
		super.lose();
	}
}
