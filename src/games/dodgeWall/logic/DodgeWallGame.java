package games.dodgeWall.logic;

import games.dodgeWall.gui.DodgeWallPanel;
import games.dodgeWall.threads.DodgeWallWatch;
import general.logic.Game;

public class DodgeWallGame extends Game{
	protected Player player;
	protected Wall wall_1;
	protected Wall wall_2;
	protected int tick;
	protected DodgeWallWatch dodgeWallWatch;
	
	public DodgeWallGame(DodgeWallPanel panel) {
		super(panel);
		DodgeWallMap map = new DodgeWallMap(this);
		this.player = new Player(map, this.panel.getImageFactory());
		this.wall_1 = new Wall(map, this.panel.getImageFactory());
		this.wall_2 = new Wall(map, this.panel.getImageFactory());
		this.dodgeWallWatch = new DodgeWallWatch(this, 200);
		this.dodgeWallWatch.start();
		this.tick = 0;
	}
	
	public synchronized void run() {
		tick++;	
		wall_1.move();
		wall_2.move();
		
		if(tick == 8) {
			wall_1.charge();
		}

		if(tick == 16) {
			wall_2.charge();
			tick = 0;
		}
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
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(dodgeWallWatch.getStep() > 60)
				dodgeWallWatch.setStep(dodgeWallWatch.getStep() - 20);
		}
	}
	
	@Override
	public void lose() {
		super.lose();
	}

}