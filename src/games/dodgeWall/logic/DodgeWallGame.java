package games.dodgeWall.logic;

import games.dodgeWall.gui.DodgeWallPanel;
import games.dodgeWall.threads.DodgeWallWatch;
import general.logic.Game;

public class DodgeWallGame extends Game{
	protected Player player;
	protected Wall wall;
	protected DodgeWallWatch DodgeWallWatch;
	
	public DodgeWallGame(DodgeWallPanel panel) {
		super(panel);
		DodgeWallMap map = new DodgeWallMap(this);
		this.player = new Player(map, this.panel.getImageFactory());
		this.wall = new Wall(map, this.panel.getImageFactory());
		this.DodgeWallWatch = new DodgeWallWatch(this, 100);
		this.DodgeWallWatch.start();
	}
	
	public synchronized void run() {
		wall.put();
	}
	
	public void moveUp() {
		player.moveUp();
	}
	public void moveDown() {
		player.moveDown();
	}

	public void moveCenter() {
		player.moveCenter();
	}
	
	public void win() {
		super.win();
	}
	
	public void lose() {
		super.lose();
	}

}
