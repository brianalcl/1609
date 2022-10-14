package games.shot.logic;

import factory.Factory;
import general.logic.GraphicCell;
import general.utilities.NRandom;

public class Wall_Shoot {
	
	protected GraphicCell representation;
	protected Map_Shoot map;
	protected Factory imageFactory;
	
	public Wall_Shoot(Map_Shoot map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getCapsule(), this.map.getFreeCell().getBackground());
	}
	
	public void put() {
		map.downLines();
		charge();
		
	}
	
	public void charge() {
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
		map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9)).put(representation);
	}
}
