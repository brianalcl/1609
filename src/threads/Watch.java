package threads;

import game.Game;

public class Watch extends Thread{
	protected Game game;
	protected boolean active;
	protected int step;
	
	public Watch(Game game, int step) {
		this.game = game;
		this.active = !game.isGameOver();
		this.step = 1000;
	}
	
	public void setStep(int step) {
		this.step=step;
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
