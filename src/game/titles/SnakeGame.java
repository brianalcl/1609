package game.titles;


import game.Game;
import gui.games.snake.SnakePanel;

public class SnakeGame extends Game{
	protected Snake snake;
	public SnakeGame(SnakePanel snakePanel) {
		super(snakePanel);
		this.map = new SnakeMap(this);
		this.snake = new Snake(map, snakePanel.getImageFactory());
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
}
