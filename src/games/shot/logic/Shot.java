package games.shot.logic;

import java.util.LinkedList;
import java.util.Queue;

import general.logic.Cell;
import general.logic.GraphicCell;
import imageFactory.ImageFactory;

public class Shot {
	protected Queue<Cell> shot;
	protected ShotMap map;
	protected GraphicCell representation;
	protected ImageFactory imageFactory;
	
	public Shot(ShotMap map, ImageFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getSquircle(), this.imageFactory.getColorDefault());
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
