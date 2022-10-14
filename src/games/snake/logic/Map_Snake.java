package games.snake.logic;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import general.utilities.NRandom;

public class Map_Snake extends Map{

	protected Cell food;
	protected int totalOccupiedCells;
	protected GraphicCell foodRep;
	
	public Map_Snake(Game_Snake snakeGame) {
		super(snakeGame, true);
		totalOccupiedCells = 3;
		foodRep = new GraphicCell(game.getImageFactory().getSquare(), freeCell.getBackground());
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
				r = Math.abs(NRandom.getInstance().nextInt()) % matrix.length;
				c = Math.abs(NRandom.getInstance().nextInt()) % matrix[0].length;
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
