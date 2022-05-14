package games.shot.logic;

import java.util.Deque;
import java.util.LinkedList;

import general.logic.Cell;
import general.logic.GraphicCell;
import imageFactory.ImageFactory;

public class Shot {
	protected Deque<Cell> shots;
	protected ShotMap map;
	protected GraphicCell representation;
	protected ImageFactory imageFactory;
	
	public Shot(ShotMap map, ImageFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getSquircle(), this.imageFactory.getColorCrimson());
		this.shots = new LinkedList<>();
	}
	
	public void putShot(int r, int c) {
		shots.addFirst(map.getCell(r, c));
		shots.getFirst().put(representation);
		
	}
	
	public void moveShot() {
		boolean posible = true;
		moveOne(shots);
		if(!shots.isEmpty()) {
			if(shots.getFirst().getColumn() == 15) {
				
				map.addPoints(100);
			}
			else {
				if(posible)
					;
			}
		}
		if (!posible) {
			map.lose();
		}
	}
	
	private void moveOne(Deque<Cell> shots) {

		if(!shots.isEmpty()) {
			Cell f = shots.removeFirst();
			moveOne(shots);
			if(f.getRow() + 1 < 16) {
				shots.addFirst(map.getCell(f.getRow() + 1, f.getColumn()));
				shots.getFirst().put(representation);
			}
			f.clear();
		}
	}
}
