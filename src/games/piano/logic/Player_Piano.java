package games.piano.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;

public class Player_Piano {
	protected Cell[] player;
	protected Factory imageFactory;
	protected Map_Piano map;
	protected GraphicCell representation;
	
	public Player_Piano(Map_Piano map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}
	
	
}
