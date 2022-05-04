package games.snake.logic;

import java.util.Deque;
import java.util.LinkedList;

import general.logic.Cell;
import general.logic.Game;
import general.logic.GraphicCell;
import general.logic.Map;
import imageFactory.ImageFactory;

public class Snake {
	protected Deque<Cell> snake;
	protected ImageFactory imageFactory;
	protected SnakeMap map;
	protected GraphicCell representation;
	protected int direction;
	protected boolean isSetDirection;
	
	public Snake(SnakeMap map, ImageFactory imageFactory) {
		this.snake = new LinkedList<>();
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(imageFactory.getSquircle(), imageFactory.getColorDarkCyan());
		this.direction = Game.MOVE_LEFT;
		this.isSetDirection = false;
		
		snake.addFirst(this.map.getCell(4, 15));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(4, 14));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(4, 13));
		snake.element().put(representation);
		
		this.map.putFood();
	}
	
	protected boolean isPosibleDirection(int direction) {
		boolean res = true;
		
		switch (direction) {
		case Game.MOVE_UP:
			res = this.direction != Game.MOVE_DOWN;
			break;
		case Game.MOVE_DOWN:
			res = this.direction != Game.MOVE_UP;
			break;
		case Game.MOVE_RIGHT:
			res = this.direction != Game.MOVE_LEFT;
			break;
		case Game.MOVE_LEFT:
			res = this.direction != Game.MOVE_RIGHT;
			break;
		}
		
		if(res) {
			this.direction = direction;
		}
		
		return res;
	}
	
	public synchronized void setDirection(int direction) {
		if(!isSetDirection) {
			isPosibleDirection(direction);
			isSetDirection = true;
		}
	}
	
	public int getDirection() {
		return direction;
	}
	
	protected boolean move(int r1, int c1) {
		boolean crash = false;
		int r = snake.getFirst().getRow() + r1;
		int c = snake.getFirst().getColumn() + c1;
		Cell newCell = null;
		
		if( r < 0 || r >= Map.ROW || c < 0 || c >= Map.COLUMN) 
			crash = true;
		else
			newCell = map.getCell(r, c);
		
		if(!crash && (newCell.isFree() || map.isFood(newCell))) {
			if(map.isFood(newCell)) {
				newCell.put(representation);
				snake.addFirst(newCell);
				map.putFood();
				map.addPoints(100);
			}
			else{
				newCell.put(representation);
				snake.addFirst(newCell);
				snake.removeLast().clear();  
			}
		}
		else {
			crash = true;
		}
		
		if(!crash) {
			isSetDirection = false;
		}
		
		return !crash;
	}
	
	public void moveUp() {
		if(!move(1,0))
			map.lose();
	}
	
	public void moveDown() {
		if(!move(-1, 0))
			map.lose();
	}
	
	public void moveLeft() {
		if(!move(0, -1))
			map.lose();
	}
	
	public void moveRight() {
		if(!move(0, 1))
			map.lose();
	}
	
}
