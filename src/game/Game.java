package game;

import gui.GeneralGamePanel;
import imageFactory.ImageFactory;
import threads.Watch;

public abstract class Game {
	public static final int MOVE_UP = 8;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 4;
	public static final int MOVE_RIGHT = 6;
	
	protected GeneralGamePanel panel;
	protected Watch watch;
	protected int seconds;
	protected int level;
	protected int points;
	protected boolean gameOver;
	
	public Game(GeneralGamePanel panel) {
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
	
	public int getPoints() {
		return points;
	}
	
	public void addLevel() {
		level++;
		panel.setLevel(level+"");
	}
	
	public int getLevel() {
		return level;
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
		System.out.println("WIN");
	}
	public void lose() {
		gameOver = true;
		System.out.println("LOSE");
	}
	public void moveUp() {}
	public void moveDown() {}
	public void moveRight() {}
	public void moveLeft() {}
}
