package games.dodgeWall.logic;

import games.dodgeWall.gui.Panel_DodgeWall;
import games.dodgeWall.threads.Clock_DodgeWall;
import general.logic.Game;

public class Game_DodgeWall extends Game{
	protected Player_DodgeWall player;
	protected Wall_DodgeWall wall_1;
	protected Wall_DodgeWall wall_2;
	protected int tick;
	protected Clock_DodgeWall clock_dodgeWall;
	
	public Game_DodgeWall(Panel_DodgeWall panel) {
		super(panel);
		Map_DodgeWall map = new Map_DodgeWall(this);
		this.player = new Player_DodgeWall(map, this.panel.getImageFactory(), this.panel.getSound());
		this.wall_1 = new Wall_DodgeWall(map, this.panel.getImageFactory());
		this.wall_2 = new Wall_DodgeWall(map, this.panel.getImageFactory());
		this.clock_dodgeWall = new Clock_DodgeWall(this, 200);
		this.clock_dodgeWall.start();
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
	
	@Override
	public void operate(int operation) {
		switch (operation) {
		case MOVE_UP:
			player.moveUp();
			break;
		case MOVE_DOWN:
			player.moveDown();
			break;
		case MOVE_CENTER:
			player.moveCenter();
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
			if(clock_dodgeWall.getStep() > 60)
				clock_dodgeWall.setStep(clock_dodgeWall.getStep() - 20);
		}
	}

}