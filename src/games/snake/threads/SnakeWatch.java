package games.snake.threads;

import games.snake.logic.SnakeGame;

public class SnakeWatch extends Thread{
	protected SnakeGame game;
	protected boolean active;
	protected int step;
	
	public SnakeWatch(SnakeGame game, int step) {
		this.game = game;
		this.step = step;
		this.active = !game.isGameOver();
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