package games.shot.logic;


import java.util.Random;
import general.logic.GraphicCell;
import general.utilities.NRandom;
import imageFactory.ImageFactory;

public class Wall {
	
	protected GraphicCell representation;
	protected ShotMap map;
	protected ImageFactory imageFactory;
	protected Random rnd;
	
	public Wall(ShotMap map, ImageFactory imageFactory) {
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
