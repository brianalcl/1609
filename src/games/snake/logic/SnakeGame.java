package games.snake.logic;


import games.snake.gui.SnakePanel;
import games.snake.threads.SnakeWatch;
import general.logic.Game;

public class SnakeGame extends Game{
	protected Snake snake;
	protected SnakeWatch snakeWatch;
	public SnakeGame(SnakePanel snakePanel) {
		super(snakePanel);
		this.snake = new Snake(new SnakeMap(this), snakePanel.getImageFactory());
		this.snakeWatch = new SnakeWatch(this, 200);
		this.snakeWatch.start();
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
		System.out.println("WIN");
	}
	
	public void lose() {
		super.win();
		System.out.println("LOSE");
	}

}
