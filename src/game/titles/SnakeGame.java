package game.titles;


import game.Game;
import gui.games.snake.SnakePanel;
import threads.SnakeWatch;

public class SnakeGame extends Game{
	protected Snake snake;
	protected SnakeWatch snakeWatch;
	public SnakeGame(SnakePanel snakePanel) {
		super(snakePanel);
		this.snake = new Snake(new SnakeMap(this), snakePanel.getImageFactory());
		this.snakeWatch = new SnakeWatch(this, 200);
		snakeWatch.start();
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
		boolean res = snake.moveUp();
		if(!res)
			System.out.println("CHOQUE_UP");
	}
	public void moveDown() {
		boolean res = snake.moveDown();
		if(!res)
			System.out.println("CHOQUE_DOWN");
	}
	public void moveRight() {
		boolean res = snake.moveRight();
		if(!res)
			System.out.println("CHOQUE_RIGHT");
	}
	public void moveLeft() {
		boolean res = snake.moveLeft();
		if(!res)
			System.out.println("CHOQUE_LEFT");
	}
	
	public void win() {
		System.out.println("WIN");
	}
}
