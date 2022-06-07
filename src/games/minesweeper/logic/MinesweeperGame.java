package games.minesweeper.logic;

import games.minesweeper.gui.MinesweeperPanel;
import general.logic.Game;

public class MinesweeperGame extends Game{
	
	protected Player player;
	protected MinesweeperPanel panel;
	
	public MinesweeperGame(MinesweeperPanel panel) {
		super(panel);
		this.panel = panel;
		this.player = new Player(new MinesweeperMap(this), this.panel.getImageFactory());
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
