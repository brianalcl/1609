package general.logic;

import factory.Factory;
import general.gui.GamePanel;
import general.sound.Sound;
import general.threads.Clock;

public abstract class Game {
	public static final int MOVE_UP = 8;
	public static final int MOVE_RIGHT = 6;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 4;
	public static final int SPACE = 5;
	public static final int ROTATE_LEFT = 7;
	public static final int ROTATE_RIGHT = 9;
	
	protected GamePanel panel;
	protected Clock clock;
	protected int seconds;
	protected int level;
	protected int points;
	protected boolean gameOver;
	protected boolean pause;
	
	public Game(GamePanel panel) {
		this.seconds = 0;
		this.level = 0;
		this.points = 0;
		this.gameOver = false;
		this.pause = false;
		this.panel = panel;
		this.clock = new Clock(this);
		this.clock.start();
	}
	
	public void changeCell(Cell cell) {
		panel.changeCell(cell.getGraphicCell(), cell.getRow(), cell.getColumn());
	}
	
	public void addPoints(int points) {
		Sound.getInstance().pointSound();
		this.points += points;
		panel.setPoints(String.format("%05d", this.points));
	}
	
	public void addLevel() {
		level++;
		panel.setLevel(String.format("%02d", this.level));
	}
	
	public void addSecond() {
		seconds++;
		int sec = seconds;
		int min = sec / 60;
		sec = sec % 60;
		String res = new StringBuilder(String.format("%02d", min))
				.append(":")
				.append(String.format("%02d", sec))
				.toString();
		panel.setTime(res);
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public Factory getImageFactory() {
		return panel.getImageFactory();
	}
	
	public void win() {
		Sound.getInstance().finishSound();
		gameOver = true;
		panel.win();
	}
	
	public void lose() {
		Sound.getInstance().finishSound();
		gameOver = true;
		panel.lose();
	}
	
	public void pause() {
		pause = !pause;
	}
	
	public boolean isPause() {
		return pause;
	}
	
}
