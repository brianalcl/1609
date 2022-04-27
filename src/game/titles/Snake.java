package game.titles;

import java.util.Deque;
import java.util.LinkedList;

import game.Cell;
import game.Game;
import game.GraphicCell;
import game.Map;
import imageFactory.ImageFactory;

public class Snake {
	protected Deque<Cell> snake;
	protected ImageFactory imageFactory;
	protected SnakeMap map;
	protected GraphicCell representation;
	protected int direction;
	
	public Snake(SnakeMap map, ImageFactory imageFactory) {
		this.snake = new LinkedList<>();
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(imageFactory.getSquircle(), imageFactory.getColor1());
		this.direction = Game.MOVE_LEFT;
		
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
	
	public int getDirection() {
		return direction;
	}
	
	protected boolean move(int r1, int c1) {
		boolean crash = false;
		Cell first = snake.getFirst();
		Cell last = snake.getLast();
		int r = first.getRow() + r1;
		int c = first.getColumn() + c1;
		Cell newCell = null;
		
		if( r < 0 || r >= Map.ROW || c < 0 || c >= Map.COLUMN) 
			crash = true;
		else
			newCell = map.getCell(r, c);
		
		if(!crash && (newCell.isFree() || map.isFood(newCell))) {
			if(map.isFood(newCell)) {
				snake.addFirst(newCell);
				snake.getFirst().put(representation);
				map.putFood();
			}
			else{
				last.clear();
				snake.addFirst(newCell);
				snake.getFirst().put(representation);
				snake.removeLast().clear();
			}
		}
		else {
			crash = true;
		}
		
		return !crash;
	}
	
	public boolean moveUp() {
		if(isPosibleDirection(Game.MOVE_UP)) 
			return move(1,0);
		else
			return true;
	}
	
	public boolean moveDown() {
		if(isPosibleDirection(Game.MOVE_DOWN)) 
			return move(-1, 0);
		else
			return true;
	}
	
	public boolean moveLeft() {
		if(isPosibleDirection(Game.MOVE_LEFT)) 
			return move(0, -1);
		else
			return true;
	}
	
	public boolean moveRight() {
		if(isPosibleDirection(Game.MOVE_RIGHT)) 
			return move(0, 1);
		else
			return true;
	}
	
}
