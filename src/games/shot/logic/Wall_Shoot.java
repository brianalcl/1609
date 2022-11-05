package games.shot.logic;

import abstractFactory.AbstractFactory;
import general.logic.GraphicCell;
import general.utilities.NRandom;

public class Wall_Shoot {
	
	protected GraphicCell representation;
	protected Map_Shoot map;
	protected AbstractFactory imageFactory;
	
	public Wall_Shoot(Map_Shoot map, AbstractFactory imageFactory) {
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
