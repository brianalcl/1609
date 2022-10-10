package games.collect.thread;

import games.collect.logic.CollectGame;

public class CollectWatch extends Thread{
	protected CollectGame game;
	protected boolean active;
	protected int step;
	
	public CollectWatch(CollectGame game, int step) {
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