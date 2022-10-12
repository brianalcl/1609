package games.piano.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;

public class Player {
	protected Cell[] player;
	protected Factory imageFactory;
	protected PianoMap map;
	protected GraphicCell representation;
	
	public Player(PianoMap map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
	}
	
	
}
