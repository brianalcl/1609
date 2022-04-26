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
	protected GraphicCell representation;
	
	public Snake(Map map, ImageFactory imageFactory) {
		this.snake = new LinkedList<>();
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(imageFactory.getSquircle(), new java.awt.Color(100,0,100));
		
		snake.addFirst(this.map.getCell(2, 0));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(1, 0));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 0));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 1));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 2));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 3));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 4));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 5));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 6));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 7));
		snake.element().put(representation);
		snake.addFirst(this.map.getCell(0, 8));
		snake.element().put(representation);
	}
	
	public void move(Cell cell, int r, int c) {
			cell.clear();
			snake.addFirst(map.getCell(r, c));
			snake.element().put(representation);
			snake.removeLast().clear();
	}
	
	public void moveUp() {
		boolean crash = false;
		
		Cell first = snake.getFirst();
		Cell last = snake.getLast();
		int r = first.getRow() + 1;
		int c = first.getColumn();
		
		if((r >= Map.ROW) || (!map.getCell(r, c).isFree()))
			crash = true;
		else {
			move(last, r,c);
		}
		
	}
	
	public void moveDown() {
		boolean crash = false;
		Cell first = snake.getFirst();
		Cell last = snake.getLast();
		int r = first.getRow() - 1;
		int c = first.getColumn();
		
		if((r < 0) || (!map.getCell(r, c).isFree()))
			crash = true;
		else {
			move(last, r,c);
		}
	}
	
	public void moveLeft() {
		boolean crash = false;
		Cell first = snake.getFirst();
		Cell last = snake.getLast();
		int r = first.getRow();
		int c = first.getColumn() - 1;
		
		if((c < 0) || (!map.getCell(r, c).isFree()))
			crash = true;
		else {
			move(last, r,c);
		}
	}
	
	public void moveRight() {
		boolean crash = false;
		Cell first = snake.getFirst();
		Cell last = snake.getLast();
		int r = first.getRow();
		int c = first.getColumn() + 1;
		
		if((c >= Map.COLUMN) || (!map.getCell(r, c).isFree()))
			crash = true;
		else {
			move(last, r,c);
		}
	}
	
}
