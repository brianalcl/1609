package games.shot.logic;


import java.util.Random;

import factory.Factory;
import general.logic.GraphicCell;
import general.utilities.NRandom;

public class Wall {
	
	protected GraphicCell representation;
	protected ShotMap map;
	protected Factory imageFactory;
	protected Random rnd;
	
	public Wall(ShotMap map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getSquircle(), this.imageFactory.getColorDefault());
		this.rnd = NRandom.getInstance();
	}
	
	public void put() {
		map.downLines();
		charge();
		
	}
	
	public void charge() {
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
		map.getCell(15, Math.abs(rnd.nextInt()%9)).put(representation);
	}
}
