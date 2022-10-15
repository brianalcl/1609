package games.snake.logic;


import games.snake.gui.Panel_Snake;
import games.snake.threads.Clock_Snake;
import general.logic.Game;

public class Game_Snake extends Game{
	protected Snake_Snake snake;
	protected Clock_Snake clock_snake;
	
	public Game_Snake(Panel_Snake panel) {
		super(panel);
		this.snake = new Snake_Snake(new Map_Snake(this), this.panel.getImageFactory(), this.panel.getSound());
		this.clock_snake = new Clock_Snake(this, 200);
		this.clock_snake.start();
	}
	
	@Override
	public void operate(int operation) {
		switch (operation) {
		case MOVE_UP:
			snake.setDirection(MOVE_UP);
			break;
		case MOVE_DOWN:
			snake.setDirection(MOVE_DOWN);
			break;
		case MOVE_LEFT:
			snake.setDirection(MOVE_LEFT);
			break;
		case MOVE_RIGHT:
			snake.setDirection(MOVE_RIGHT);
			break;
		default:
			break;
		}
	}
	
	public synchronized void run() {
		int direction = snake.getDirection();
		switch (direction) {
		case Game.MOVE_UP:
			snake.moveUp();
			break;
		case Game.MOVE_DOWN:
			snake.moveDown();
			break;
		case Game.MOVE_RIGHT:
			snake.moveRight();
			break;
		case Game.MOVE_LEFT:
			snake.moveLeft();
			break;
		}
	}

}
