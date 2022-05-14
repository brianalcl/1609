package games.shot.threads;

import games.shot.logic.ShotGame;

public class ShotWatch extends Thread{
	protected ShotGame game;
	protected boolean active;
	protected int step;
	
	public ShotWatch(ShotGame game, int step) {
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