package games.dodgeWall.logic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.random.NRandom;
import imageFactory.ImageFactory;

public class Wall {
	
	protected Deque<Cell> wall_1;
	protected Deque<Cell> wall_2;
	protected GraphicCell representation;
	protected DodgeWallMap map;
	protected ImageFactory imageFactory;
	protected int num;
	protected Random rnd;
	
	public Wall(DodgeWallMap map, ImageFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getSquircle(), this.imageFactory.getColorBrown());
		this.num = 0;
		this.rnd = NRandom.getInstance();
		this.wall_1 = new LinkedList<Cell>();
		this.wall_2 = new LinkedList<Cell>();
	}
	
	public void put() {
		num++;		
		move(wall_1);
		move(wall_2);
		if(num == 8) {
			if(wall_1.isEmpty())
				charge(wall_1);
			else
				if(wall_2.isEmpty())
					charge(wall_2);
			num = 0;
		}

	}
	
	public void move(Deque<Cell> wall) {
		boolean posible = true;
		
		if(!wall.isEmpty()) {
			if(wall.getFirst().getColumn() == 0) {
				clearWall(wall, wall.removeFirst(), wall.removeLast());
				map.addPoints(100);
			}
			else {
				posible = map.getCell(wall.getFirst().getRow(), wall.getFirst().getColumn()-1).isFree();
				posible = posible && map.getCell(wall.getLast().getRow(), wall.getLast().getColumn()-1).isFree();
				if(posible)
					moveOne(wall, wall.removeFirst(), wall.removeLast());
			}
		}
		if (!posible) {
			map.lose();
		}
	}
	
	private void clearWall(Deque<Cell> wall, Cell first, Cell last) {
		if(!wall.isEmpty()) 
			clearWall(wall, wall.removeFirst(), wall.removeLast());
			first.clear();
			last.clear();
	}
	
	private void moveOne(Deque<Cell> wall, Cell first, Cell last) {
		if(!wall.isEmpty()) 
			moveOne(wall, wall.removeFirst(), wall.removeLast());	
		first.clear();
		last.clear();
		wall.addFirst(map.getCell(first.getRow(), first.getColumn()-1));
		wall.getFirst().put(representation);
		wall.addLast(map.getCell(last.getRow(), last.getColumn()-1));
		wall.getLast().put(representation);
	}
	
	public void charge(Deque<Cell> wall) {
		Cell act = null;
		int x = Math.abs(rnd.nextInt()%3);
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
