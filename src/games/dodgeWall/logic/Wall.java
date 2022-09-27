package games.dodgeWall.logic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;
import general.utilities.NRandom;

public class Wall {
	
	protected Deque<Cell> wall;
	protected GraphicCell representation;
	protected DodgeWallMap map;
	protected Factory imageFactory;
	protected Random rnd;
	
	public Wall(DodgeWallMap map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getSquircle(), this.map.getFreeCell().getBackground());
		this.rnd = NRandom.getInstance();
		this.wall = new LinkedList<Cell>();
	}
	
	public void move() {
		boolean posible = true;
		
		if(!wall.isEmpty()) {
			if(wall.getFirst().getColumn() == 0) {
				clearWall(wall.removeFirst(), wall.removeLast());
				map.addPoints(100);
			}
			else {
				posible = map.getCell(wall.getFirst().getRow(), wall.getFirst().getColumn() - 1).isFree();
				posible = posible && map.getCell(wall.getLast().getRow(), wall.getLast().getColumn() - 1).isFree();
				if(posible)
					moveOne(wall.removeFirst(), wall.removeLast());
			}
		}
		if (!posible) {
			map.lose();
		}
	}
	
	private void clearWall(Cell first, Cell last) {
		if(!wall.isEmpty())
			clearWall(wall.removeFirst(), wall.removeLast());
		first.clear();
		last.clear();
	}
	
	private void moveOne(Cell first, Cell last) {
		if(!wall.isEmpty()) 
			moveOne(wall.removeFirst(), wall.removeLast());	
		first.clear();
		last.clear();
		wall.addFirst(map.getCell(first.getRow(), first.getColumn() - 1));
		wall.getFirst().put(representation);
		wall.addLast(map.getCell(last.getRow(), last.getColumn() - 1));
		wall.getLast().put(representation);
		
	}
	
	public void charge() {
		Cell act = null;
		int x = Math.abs(rnd.nextInt() % 3);
		switch (x) {
		case 0:
			act = map.getCell(0, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(1, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(2, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(3, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(4, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(5, 15);
			act.put(representation);
			wall.addFirst(act);
			break;
		case 1:
			act = map.getCell(0, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(1, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(2, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(6, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(7, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(8, 15);
			act.put(representation);
			wall.addFirst(act);
			break;
		case 2:
			act = map.getCell(3, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(4, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(5, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(6, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(7, 15);
			act.put(representation);
			wall.addFirst(act);
			act = map.getCell(8, 15);
			act.put(representation);
			wall.addFirst(act);
			break;
		default:
			break;
		}
	}
	
}
