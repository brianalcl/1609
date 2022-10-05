package games.tetris.threads;
import games.tetris.logic.TetrisGame;
import general.logic.Game;

public class TetrisWatch extends Thread{
	protected TetrisGame tetrisGame;
	protected boolean active;
	protected int step;
	
	/**
	* Create a clock with the TetrisGame and the step.
	* @param tetrisGame The tetrisGame.
	* @param step The step.
	*/
	public TetrisWatch(TetrisGame tetrisGame, int step) {
		this.tetrisGame = tetrisGame;
		this.active = !this.tetrisGame.isGameOver();
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
				tetrisGame.operate(Game.MOVE_DOWN);
				active = !tetrisGame.isGameOver();
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
