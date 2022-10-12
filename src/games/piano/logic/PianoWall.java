package games.piano.logic;

import java.util.Deque;
import java.util.LinkedList;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;
import general.utilities.NRandom;

public class PianoWall {
	protected Factory factory;
	protected GraphicCell representation;
	protected PianoMap map;
	protected Deque<Cell> wall;
	protected int count;
	protected int pos;
	protected boolean click;
	
	public PianoWall(PianoMap map, Factory factory) {
		this.factory = factory;
		this.map = map;
		this.representation = new GraphicCell(this.factory.getCircle(), this.map.getFreeCell().getBackground());
		this.count = 0;
		this.pos = 0;
		this.click = false;
		this.wall = new LinkedList<>();
	}
	
	public boolean getClick() {
		return this.click;
	}
	
	public boolean click(int pos) {
		if(this.pos == pos && !click && !wall.isEmpty() && wall.getLast().getRow() - 4 < 0) {
			map.addPoints(100);
			click = true;
		}
		return click;
	}
	
	public void charge() { 
		move();
		Cell act = null;
		if(count == 0) {
			pos = Math.abs(NRandom.getInstance().nextInt() % 3);
		}
		if(count < 4) {
			switch (pos) {
			case 0:
				act = map.getCell(15 - count, 0);
				act.put(representation);
				wall.addFirst(act);
				act = map.getCell(15 - count, 1);
				act.put(representation);
				wall.addFirst(act);
				act = map.getCell(15 - count, 2);
				act.put(representation);
				wall.addFirst(act);
				break;
			case 1:
				act = map.getCell(15 - count, 3);
				act.put(representation);
				wall.addFirst(act);
				act = map.getCell(15 - count, 4);
				act.put(representation);
				wall.addFirst(act);
				act = map.getCell(15 - count, 5);
				act.put(representation);
				wall.addFirst(act);
				break;
			case 2:
				act = map.getCell(15 - count, 6);
				act.put(representation);
				wall.addFirst(act);
				act = map.getCell(15 - count, 7);
				act.put(representation);
				wall.addFirst(act);
				act = map.getCell(15 - count, 8);
				act.put(representation);
				wall.addFirst(act);
				break;
			default:
				break;
			}	
			count++;
		}
			
	}
	
	public void move() {
		Cell act = null;
		if(count == 4) {
			if(!wall.isEmpty()) {
				for(int i = 0; i < 3; i++) {
					act = wall.removeLast();
					act.clear();
					if(act.getRow() - 4 >= 0) {
						wall.addFirst(map.getCell(act.getRow() - 4, act.getColumn()));
						wall.getFirst().put(representation);
					}
				}
			}
			else {
				count = 0;
				if(click == false)
					map.lose();
				else
					click = false;
			}
		}
	}
}
