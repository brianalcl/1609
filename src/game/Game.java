package game;

import gui.GeneralGamePanel;
import threads.Watch;

public abstract class Game {
	
	protected Map map;
	protected GeneralGamePanel panel;
	protected Watch watch;
	protected int seconds;
	protected int level;
	protected int points;
	protected boolean gameOver;
	
	public Game() {
		this.seconds = 0;
		this.level = 1;
		this.points = 0;
		this.gameOver = false;
		this.panel = null;
		this.map = null;
		
	}
	
	protected void initialize() {
		this.panel.setPoints(points+"");
		this.panel.setTime("");
		this.panel.setLevel(level+"");
		this.watch = new Watch(this, 1000);
		start();
	}
	
	public void changeCell(Cell cell) {
		//TODO hacer despues
	}
	
	public void addPoints(int points) {
		this.points += points;
		panel.setPoints(this.points+"");
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
	
	public void start() {
		watch.start();
	}
	
	public void addSecond() {
		seconds++;
		int sec = seconds;
		int min = sec / 60;
		sec = sec % 60;
		String res = new StringBuilder(String.format("%02d", min))
				.append(" : ")
				.append(String.format("%02d", sec))
				.toString();
		panel.setTime(res); System.out.println(res);
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	

}
