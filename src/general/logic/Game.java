package general.logic;

import general.gui.GamePanel;
import general.threads.Watch;
import imageFactory.ImageFactory;

public abstract class Game {
	public static final int MOVE_UP = 8;
	public static final int MOVE_RIGHT = 6;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 4;
	public static final int SPACE = 5;
	
	protected GamePanel panel;
	protected Watch watch;
	protected int seconds;
	protected int level;
	protected int points;
	protected boolean gameOver;
	
	public Game(GamePanel panel) {
		this.seconds = 0;
		this.level = 0;
		this.points = 0;
		this.gameOver = false;
		this.panel = panel;
		this.watch = new Watch(this);
		this.watch.start();
	}
	
	public void changeCell(Cell cell) {
		panel.changeCell(cell.getGraphicCell(), cell.getRow(), cell.getColumn());
	}
	
	public void addPoints(int points) {
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
	
	public ImageFactory getImageFactory() {
		return panel.getImageFactory();
	}
	
	public void win() {
		gameOver = true;
		panel.win();
	}
	
	public void lose() {
		gameOver = true;
		panel.lose();
	}
	
	public void moveUp() {}
	public void moveDown() {}
	public void moveRight() {}
	public void moveLeft() {}
	public void moveSpace() {}
}
