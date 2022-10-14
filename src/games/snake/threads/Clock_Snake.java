package games.snake.threads;

import games.snake.logic.Game_Snake;

public class Clock_Snake extends Thread{
	protected Game_Snake game;
	protected boolean active;
	protected int step;
	
	public Clock_Snake(Game_Snake game, int step) {
		this.game = game;
		this.step = step;
		this.active = !game.isGameOver();
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