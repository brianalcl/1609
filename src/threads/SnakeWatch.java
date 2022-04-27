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
	
	public void setStep(int step) {
		this.step=step;
	}
	
	public void sleep(int step) {
		try {
			Thread.sleep(step);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(this.active) { 
			try {
				Thread.sleep(step);
				game.run();
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