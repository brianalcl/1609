package games.snake.logic;

import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;

public class SnakeMap extends Map{

	protected Cell food;
	protected Random rnd;
	protected int totalOccupiedCells;
	
	public SnakeMap(SnakeGame snakeGame) {
		super(snakeGame);
		rnd = new Random();
		totalOccupiedCells = 3;
	}
	
	public boolean isFood(Cell cell) {
		return food.equals(cell);
	}
	
	public void putFood() {
		int r = 0;
		int c = 0;
		boolean stop = false;
		
		if(totalOccupiedCells == ROW * COLUMN)
			lose();
		else {
			while(!stop) { 
				r = Math.abs(rnd.nextInt()) % 9;
				c = Math.abs(rnd.nextInt()) % 16;
				if(matrix[r][c].isFree()) {
					food = matrix[r][c];
					food.put(new GraphicCell(game.getImageFactory().getSquircle(), game.getImageFactory().getColorRandom()));
					stop = true;
					totalOccupiedCells++;
				}
			}
		}
	}
	
}
