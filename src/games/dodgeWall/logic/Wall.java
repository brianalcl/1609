package games.dodgeWall.logic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import imageFactory.ImageFactory;

public class Wall {
	
	protected Queue<Cell> wall_1;
	protected Queue<Cell> wall_2;
	protected GraphicCell representation;
	protected DodgeWallMap map;
	protected ImageFactory imageFactory;
	protected int num;
	protected Random rnd;
	
	public Wall(DodgeWallMap map, ImageFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getSquircle(), this.imageFactory.getColorRebeccaPurple());
		this.num = 0;
		this.rnd = new Random();
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
	
	public void move(Queue<Cell> wall) {
		Cell act = null;
		boolean crash = false;
		
		if(!wall.isEmpty()) {
			if(wall.peek().getColumn() == 0) {
				while(!wall.isEmpty()) {
					wall.poll().clear();
				}
				map.addPoints(100);
			}
			for(int i = 0; i < wall.size() && !crash; i++) {
				act = wall.poll();
				act.clear();
				act = map.getCell(act.getRow(), act.getColumn()-1);
				crash = !act.isFree();
				if(!crash) {
					act.put(representation);
					wall.add(act);
				}
			}
		}
		if (crash) {
			map.lose();
		}
	}

	public void charge(Queue<Cell> wall) {
		Cell act = null;
		int x = Math.abs(rnd.nextInt()%3);
		switch (x) {
		case 0:
			act = map.getCell(0, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(1, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(2, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(3, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(4, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(5, 15);
			act.put(representation);
			wall.add(act);
			break;
		case 1:
			act = map.getCell(0, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(1, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(2, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(6, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(7, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(8, 15);
			act.put(representation);
			wall.add(act);
			break;
		case 2:
			act = map.getCell(3, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(4, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(5, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(6, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(7, 15);
			act.put(representation);
			wall.add(act);
			act = map.getCell(8, 15);
			act.put(representation);
			wall.add(act);
		default:
			break;
		}
	}
}
