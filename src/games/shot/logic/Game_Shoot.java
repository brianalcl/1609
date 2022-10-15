package games.shot.logic;

import games.shot.gui.Panel_Shoot;
import games.shot.threads.Clock_Shoot;
import general.logic.Game;

public class Game_Shoot extends Game{
	protected Player_Shoot player;
	protected Wall_Shoot wall;
	protected Clock_Shoot clock_shoot;
	protected int tick;
	
	public Game_Shoot(Panel_Shoot panel) {
		super(panel);
		Map_Shoot map = new Map_Shoot(this);
		this.player = new Player_Shoot(map, this.panel.getImageFactory(), this.panel.getSound());
		this.wall = new Wall_Shoot(map, this.panel.getImageFactory());
		this.clock_shoot = new Clock_Shoot(this, 200);
		this.tick = 20;
		this.clock_shoot.start();
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
		case SPACE:
			player.shot();
			break;
		default:
			break;
		}
	}
	
	public synchronized void run() {
		
		if(tick == 20) {
			wall.put();
			tick = 0;
		}
		tick++;
		player.moveShot();
	}
	
	public boolean isShot(int r, int c) {
		return player.isShot(r,c);
	}
	
	public void moveShot() {
		player.moveShot();
	}
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(clock_shoot.getStep() > 40)
				clock_shoot.setStep(clock_shoot.getStep()-20);
		}
	}


}
