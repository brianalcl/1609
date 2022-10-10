package games.collect.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;
import general.utilities.NRandom;

public class CollectPoint {
	protected Cell wall;
	protected GraphicCell representation;
	protected CollectMap map;
	protected Factory imageFactory;
	
	public CollectPoint(CollectMap map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getCircle(), this.map.getFreeCell().getBackground());
	}
	
	public void move() {
		boolean posible = true;
		
		if(wall != null && !wall.isFree()) {
			if(wall.getRow() == 1) {
				if(!map.getCell(wall.getRow() - 1, wall.getColumn()).isFree()) {
					wall.clear();
					map.addPoints(100);
				}
				else
					posible = false;
			}
			else {
				wall.clear();
				wall = map.getCell(wall.getRow() - 1, wall.getColumn());
				wall.put(representation);
			}
		}
		if (!posible) {
			map.lose();
		}
	}
	
	public void charge() {
		wall = map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9));
		wall.put(representation);
	}
	
}
