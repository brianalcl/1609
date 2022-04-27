package threads;

import game.titles.Snake;
import game.titles.SnakeGame;

public class SnakeWatch extends Thread{
	protected SnakeGame game;
	protected boolean active;
	protected int step;
	
	public SnakeWatch(SnakeGame game, int step) {
		this.game = game;
		this.step = step;
		this.active = true;
	}
	
	@Override
	public void run() {
		while(this.active) { 
			try {
				game.run();
				Thread.sleep(step);
				this.active = true;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Detiene el reloj.
	 */
	public void stopWatch() {
		this.active = false;
	}
}