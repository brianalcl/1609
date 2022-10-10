package games.collect.logic;

import games.collect.gui.CollectPanel;
import games.collect.thread.CollectWatch;
import general.logic.Game;

public class CollectGame extends Game{
	protected Player player;
	protected CollectPoint wall;
	protected CollectWatch shotWatch;
	protected int tick;
	protected CollectPoint wall_1;
	protected CollectPoint wall_2;
	protected CollectPoint wall_3;
	protected CollectPoint wall_4;
	
	public CollectGame(CollectPanel panel) {
		super(panel);
		CollectMap map = new CollectMap(this);
		this.player = new Player(map, this.panel.getImageFactory());
		this.wall = new CollectPoint(map, this.panel.getImageFactory());
		this.shotWatch = new CollectWatch(this, 400);
		this.wall_1 = new CollectPoint(map, this.panel.getImageFactory());
		this.wall_2 = new CollectPoint(map, this.panel.getImageFactory());
		this.wall_3 = new CollectPoint(map, this.panel.getImageFactory());
		this.wall_4 = new CollectPoint(map, this.panel.getImageFactory());
		this.tick = 0;
		this.shotWatch.start();
	}
	
	public synchronized void run() {
		tick++;	
		wall_1.move();
		wall_2.move();
		wall_3.move();
		wall_4.move();
		if(tick == 4) {
			wall_1.charge();
		}
		if(tick == 8) {
			wall_2.charge();
		}
		if(tick == 12) {
			wall_3.charge();
		}
		if(tick == 16) {
			wall_4.charge();
			tick = 0;
		}
	}
	
	public void moveLeft() {
		player.moveLeft();
	}

	public void moveRight() {
		player.moveRight();
	}
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(shotWatch.getStep() > 40)
				shotWatch.setStep(shotWatch.getStep() - 20);
		}
	}
	
	@Override
	public void lose() {
		super.lose();
	}
	
}