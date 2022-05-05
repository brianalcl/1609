package games.dodgeWall.logic;

import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;

public class DodgeWallMap extends Map{

	protected Cell food;
	protected Random rnd;
	protected int totalOccupiedCells;
	
	public DodgeWallMap(DodgeWallGame game) {
		super(game);
		rnd = new Random();
		totalOccupiedCells = 3;
	}
	

	
}
