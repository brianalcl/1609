package games.collect.logic;

import games.collect.gui.Panel_Collect;
import games.collect.thread.Clock_Collect;
import general.logic.Game;

public class Game_Collect extends Game{
	protected Player_Collect player;
	protected Clock_Collect clock_collect;
	protected int tick;
	protected Point_Collect point_1;
	protected Point_Collect point_2;
	protected Point_Collect point_3;
	protected Point_Collect point_4;
	
	public Game_Collect(Panel_Collect panel) {
		super(panel);
		Map_Collect map = new Map_Collect(this);
		this.player = new Player_Collect(map, this.panel.getImageFactory(), this.panel.getSound());
		this.clock_collect = new Clock_Collect(this, 400);
		this.point_1 = new Point_Collect(map, this.panel.getImageFactory());
		this.point_2 = new Point_Collect(map, this.panel.getImageFactory());
		this.point_3 = new Point_Collect(map, this.panel.getImageFactory());
		this.point_4 = new Point_Collect(map, this.panel.getImageFactory());
		this.tick = 0;
		this.clock_collect.start();
	}
	
	public synchronized void run() {
		tick++;	
		point_1.move();
		point_2.move();
		point_3.move();
		point_4.move();
		if(tick == 4) {
			point_1.charge();
		}
		if(tick == 8) {
			point_2.charge();
		}
		if(tick == 12) {
			point_3.charge();
		}
		if(tick == 16) {
			point_4.charge();
			tick = 0;
		}
	}
	
	@Override
	public void operate(int operation) {
		switch (operation) {
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
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(clock_collect.getStep() > 40)
				clock_collect.setStep(clock_collect.getStep() - 20);
		}
	}
	
}