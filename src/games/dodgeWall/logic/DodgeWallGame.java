package games.dodgeWall.logic;

import games.dodgeWall.gui.DodgeWallPanel;
import games.dodgeWall.threads.DodgeWallWatch;
import general.logic.Game;

public class DodgeWallGame extends Game{
	protected Player player;
	protected DodgeWallWatch snakeWatch;
	
	public DodgeWallGame(DodgeWallPanel panel) {
		super(panel);
		this.player = new Player(new DodgeWallMap(this), this.panel.getImageFactory());
		this.snakeWatch = new DodgeWallWatch(this, 200);
		this.snakeWatch.start();
	}
	
	public synchronized void run() {

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
		System.out.println("WIN");
	}
	
	public void lose() {
		super.lose();
		System.out.println("LOSE");
	}

}
