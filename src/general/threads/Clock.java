package general.threads;

import general.logic.Game;

public class Clock extends Thread{
	protected boolean active;
	protected Game game;
	protected long currentTime;
	protected int FPS;
	
	public Clock(Game game) {
		this.game = game;
		this.active = !game.isGameOver();
		this.currentTime = System.nanoTime();
		this.FPS = 60;
	}
	
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime = 0;
		long timer = 0;
		
		while(active) { 
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				game.repaint();
				delta--;
			}
			
			if(timer >= 1000000000) {
				if(!game.isPause())
					game.addSecond();
				timer = 0;
			}
			active = !game.isGameOver();
		}
	}
	
	public void stopWatch() {
		this.active = false;
	}
}
