package games.piano.thread;

import games.piano.logic.Game_Piano;

public class Clock_Piano extends Thread{
	protected Game_Piano game;
	protected boolean active;
	protected int step;
	
	public Clock_Piano(Game_Piano game, int step) {
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