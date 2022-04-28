package threads;

import game.Game;

public class Watch extends Thread{
	protected Game game;
	protected boolean active;
	protected int step;
	
	public Watch(Game game) {
		this.game = game;
		this.step = 1000;
		active = !game.isGameOver();
	}
	
	@Override
	public void run() {
		while(this.active) { 
			try {
				
				Thread.sleep(step);
				game.addSecond();
				this.active = !game.isGameOver();
				
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
