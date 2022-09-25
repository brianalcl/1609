package games.snake.logic;

import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import general.utilities.NRandom;

public class SnakeMap extends Map{

	protected Cell food;
	protected Random rnd;
	protected int totalOccupiedCells;
	protected GraphicCell foodRep;
	
	public SnakeMap(SnakeGame snakeGame) {
		super(snakeGame, true);
		rnd = NRandom.getInstance();
		totalOccupiedCells = 3;
		foodRep = new GraphicCell(game.getImageFactory().getSquircle(), freeCell.getBackground());
	}
	
	public boolean isFood(Cell cell) {
		return food.equals(cell);
	}
	
	public void putFood() {
		int r = 0;
		int c = 0;
		boolean stop = false;
		
		if(totalOccupiedCells == matrix.length * matrix[0].length)
			win();
		else {
			while(!stop) { 
				r = Math.abs(rnd.nextInt()) % matrix.length;
				c = Math.abs(rnd.nextInt()) % matrix[0].length;
				if(matrix[r][c].isFree()) {
					food = matrix[r][c];
					food.put(foodRep);
					stop = true;
					totalOccupiedCells++;
				}
			}
		}
	}
	
}
