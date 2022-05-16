package games.shot.logic;

import games.shot.gui.ShotPanel;
import games.shot.threads.ShotWatch;
import general.logic.Game;

public class ShotGame extends Game{
	protected Player player;
	protected Wall wall;
	protected ShotWatch shotWatch;
	protected int stepMoveWall;
	
	public ShotGame(ShotPanel panel) {
		super(panel);
		ShotMap map = new ShotMap(this);
		this.player = new Player(map, this.panel.getImageFactory());
		this.wall = new Wall(map, this.panel.getImageFactory());
		this.shotWatch = new ShotWatch(this, 200);
		this.shotWatch.start();
		this.stepMoveWall = 20;
	}
	
	public synchronized void run() {
		
		if(stepMoveWall == 20) {
			wall.put();
			stepMoveWall = 0;
		}
		stepMoveWall++;
		player.moveShot();
	}
	
	public boolean isShot(int r, int c) {
		return player.isShot(r,c);
	}
	
	public void moveLeft() {
		player.moveLeft();
	}

	public void moveRight() {
		player.moveRight();
	}
	
	public void shot() {
		player.shot();
	}
	
	public void moveShot() {
		player.moveShot();
	}
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(shotWatch.getStep() > 40)
				shotWatch.setStep(shotWatch.getStep()-20);
		}
	}
	
	@Override
	public void lose() {
		super.lose();
	}


}
