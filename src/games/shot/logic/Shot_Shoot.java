package games.shot.logic;

import java.util.LinkedList;
import java.util.Queue;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;

public class Shot_Shoot {
	protected Queue<Cell> shot;
	protected Map_Shoot map;
	protected GraphicCell representation;
	protected Factory imageFactory;
	
	public Shot_Shoot(Map_Shoot map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getCircle(), this.map.getFreeCell().getBackground());
		this.shot = new LinkedList<>();
	}
	
	public void putShot(int r, int c) {
		Cell cell = map.getCell(r, c);
		if(cell.isFree()) {
			cell.put(representation);
			shot.add(cell);
		} 
		else {
			if (!shot.contains(cell)) {
				cell.put(representation);
				shot.add(cell);
			}
		}
		
	}
	
	public boolean isShot(int r, int c) {
		return shot.contains(map.getCell(r, c));
	}
	
	public void moveShot() {
		moveOne();
	}
	
	private void moveOne() {
		int row = 0;
		int column = 0;
		int i = 0;
		while(i < shot.size()) {
			Cell c = null;
			c = shot.remove();
			row = c.getRow();
			column = c.getColumn();
			c.clear();

			if (row < 15)
			{
				c = map.getCell(row + 1, column);
				if(c.isFree()) {
					c.put(representation);
					shot.add(c);
					i++;
				}
				else {
					c.clear();
					map.addPoints(50);
				}
			}
		}
	}
	
}
