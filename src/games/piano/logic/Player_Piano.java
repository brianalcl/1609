package games.piano.logic;

import abstractFactory.AbstractFactory;
import general.logic.Cell;
import general.logic.GraphicCell;

public class Player_Piano {
	protected Cell[] player;
	protected AbstractFactory imageFactory;
	protected Map_Piano map;
	protected GraphicCell representation;
	
	public Player_Piano(Map_Piano map, AbstractFactory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}
	
	
}
