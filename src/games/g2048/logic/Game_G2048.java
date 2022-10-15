package games.g2048.logic;

import games.g2048.gui.Panel_G2048;
import general.logic.Game;

public class Game_G2048 extends Game{
	
	protected Player_G2048 player;
	
	public Game_G2048(Panel_G2048 panel) {
		super(panel);
		this.player = new Player_G2048(new Map_G2048(this), this.panel.getImageFactory());
	}

	@Override
	public void operate(int operation) {
		switch (operation) {
		case MOVE_DOWN:
			player.moveDown();
			break;
		case MOVE_UP:
			player.moveUp();
			break;
		case MOVE_LEFT:
			player.moveLeft();
			break;
		case MOVE_RIGHT:
			player.moveRight();
			break;
		default:
			break;
		}
	}
	
}
