package games.minesweeper.logic;

import games.minesweeper.gui.Panel_Minesweeper;
import general.logic.Game;

public class Game_Minesweeper extends Game{
	
	protected Player_Minesweeper player;
	protected Panel_Minesweeper panel;
	
	public Game_Minesweeper(Panel_Minesweeper panel) {
		super(panel);
		this.panel = panel;
		this.player = new Player_Minesweeper(new Map_Minesweeper(this), this.panel.getImageFactory());
	}
	
	public void lose() {
		super.lose();
	}
	
	public void win() {
		super.win();
	}

	public void click(int x, int y) {
		int row = Math.abs((y - 15)%16);
		int column = x;
		player.click(row, column);
	}

	public void putFlag(int x, int y) {
		int row = Math.abs((y - 15)%16);
		int column = x;
		player.putFlag(row, column);
	}

}
