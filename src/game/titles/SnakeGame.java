package game.titles;

import game.Game;
import game.Map;
import gui.GeneralGamePanel;
import gui.games.snake.SnakePanel;

public class SnakeGame extends Game{

	public SnakeGame(SnakePanel snakePanel) {
		super();
		this.panel = snakePanel;
		this.map = new SnakeMap(this);
		initialize();
	}

}
