package games.dodgeWall.threads;

import games.dodgeWall.logic.Game_DodgeWall;

public class Clock_DodgeWall extends Thread{
	protected Game_DodgeWall game;
	protected boolean active;
	protected int step;
	
	public Clock_DodgeWall(Game_DodgeWall game, int step) {
		this.game = game;
		this.step = step;
		this.active = !game.isGameOver();
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public int getStep() {
		return step;
	}
	
	@Override
	public void run() {
		while(active) { 
			try {	
				Thread.sleep(step);
				if(!game.isPause())
					game.run();
				active = !game.isGameOver();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	public void stopWatch() {
		this.active = false;
	}
}