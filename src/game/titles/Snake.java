package game.titles;

import java.util.Deque;
import java.util.LinkedList;

import game.Cell;
import game.GraphicCell;
import game.Map;
import imageFactory.ImageFactory;

public class Snake {
	protected Deque<Cell> snake;
	protected ImageFactory imageFactory;
	protected Map map;
	
	
	public Snake(Map map, ImageFactory imageFactory) {
		this.snake = new LinkedList<>();
		this.map = map;
		this.imageFactory = imageFactory;
		
		
		snake.add(this.map.getCell(0, 0));
		snake.element().push(new GraphicCell(imageFactory.getSquircle(), new java.awt.Color(100,0,100)));
	}
	
	public void moveUp() {
		Cell last = snake.poll();
		int r = last.getRow();
		int c = last.getColumn();
		last.pop();
		snake.add(map.getCell(r-1, c));
		snake.element().push(new GraphicCell(imageFactory.getSquircle(), new java.awt.Color(100,0,100)));
	}
	
	public void moveDown() {
		Cell last = snake.poll();
		int r = last.getRow();
		int c = last.getColumn();
		last.pop();
		snake.add(map.getCell(r+1, c));
		snake.element().push(new GraphicCell(imageFactory.getSquircle(), new java.awt.Color(100,0,100)));
	}
	
	public void moveLeft() {
		Cell last = snake.poll();
		int r = last.getRow();
		int c = last.getColumn();
		last.pop();
		snake.add(map.getCell(r, c-1));
		snake.element().push(new GraphicCell(imageFactory.getSquircle(), new java.awt.Color(100,0,100)));
	}
	
	public void moveRight() {
		Cell last = snake.poll();
		int r = last.getRow();
		int c = last.getColumn();
		last.pop();
		snake.add(map.getCell(r, c+1));
		snake.element().push(new GraphicCell(imageFactory.getSquircle(), new java.awt.Color(100,0,100)));
	}
	
}
