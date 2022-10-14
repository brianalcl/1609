package games.tetris.threads;
import games.tetris.logic.Game_Tetris;
import general.logic.Game;

public class Clock_Tetris extends Thread{
	protected Game_Tetris game;
	protected boolean active;
	protected int step;
	
	/**
	* Create a clock with the TetrisGame and the step.
	* @param tetrisGame The tetrisGame.
	* @param step The step.
	*/
	public Clock_Tetris(Game_Tetris game, int step) {
		this.game = game;
		this.active = !this.game.isGameOver();
		this.step = step;
	}
	
	/**
	* Set the step in miliseconds.
	* @param step miliseconds.
	*/
	public void setStep(int step) {
		this.step = step;
	}
	
	/**
	 * Return the step.
	 * @return the step.
	 */
	public int getStep() {
		return step;
	}
	
	/**
	 * Start the watch.
	 */
	@Override
	public void run() {
		while(active) {
			try {
				Thread.sleep(step);
				if(!game.isPause())
					game.operate(Game.MOVE_DOWN);
				active = !game.isGameOver();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	/**
	* Stops the watch.
	*/
	public void stopWatch() {
		this.active = false;
	}
}
