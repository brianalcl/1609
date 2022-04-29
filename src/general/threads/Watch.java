package general.threads;

import general.logic.Game;

public class Watch extends Thread{
	protected Game game;
	protected boolean active;
	protected int step;
	
	public Watch(Game game) {
		this.game = game;
		this.step = 1000;
		this.active = !game.isGameOver();
	}
	
	@Override
	public void run() {
		while(active) { 
			try {
				Thread.sleep(step);
				game.addSecond();
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
