package games.dodgeWall.threads;

import games.dodgeWall.logic.DodgeWallGame;

public class DodgeWallWatch extends Thread{
	protected DodgeWallGame game;
	protected boolean active;
	protected int step;
	
	public DodgeWallWatch(DodgeWallGame game, int step) {
		this.game = game;
		this.step = step;
		this.active = !game.isGameOver();
	}
	
	@Override
	public void run() {
//		while(active) { 
//			try {	
//				Thread.sleep(step);
//				game.run();
//				active = !game.isGameOver();
//			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
//				e.printStackTrace();
//			}
//		}
	}
	
	public void stopWatch() {
		this.active = false;
	}
}