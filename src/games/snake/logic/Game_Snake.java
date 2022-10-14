package games.snake.logic;


import games.snake.gui.Panel_Snake;
import games.snake.threads.Clock_Snake;
import general.logic.Game;

public class Game_Snake extends Game{
	protected Snake_Snake snake;
	protected Clock_Snake clock_snake;
	
	public Game_Snake(Panel_Snake snakePanel) {
		super(snakePanel);
		this.snake = new Snake_Snake(new Map_Snake(this), this.panel.getImageFactory());
		this.clock_snake = new Clock_Snake(this, 200);
		this.clock_snake.start();
	}
	
	public synchronized void run() {
		int direction = snake.getDirection();
		switch (direction) {
		case Game.MOVE_UP:
			moveUp();
			break;
		case Game.MOVE_DOWN:
			moveDown();
			break;
		case Game.MOVE_RIGHT:
			moveRight();
			break;
		case Game.MOVE_LEFT:
			moveLeft();
			break;
		}
	}
	
	public void setDirection(int direction) {
		snake.setDirection(direction);
	}
	
	public void moveUp() {
		snake.moveUp();
	}
	public void moveDown() {
		snake.moveDown();
	}
	public void moveRight() {
		snake.moveRight();
	}
	public void moveLeft() {
		snake.moveLeft();
	}
	
	public void win() {
		super.win();
	}
	
	public void lose() {
		super.lose();
	}

}
