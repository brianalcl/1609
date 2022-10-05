package games.tetris.logic;

import general.logic.Map;

public class TetrisMap extends Map{

	/**
	* Create a Tetris map.
	* @param tetrisGame The Tetris game.
	*/
	public TetrisMap(TetrisGame tetrisGame) {
		super(tetrisGame, false);
	}
	
	/**
	 * Check if the rows are filled and if so, go down the line and tell the game to increase the score.
	 */
	public void checkLines() {
		boolean fullLine = true;
		int count = 0;
		int row = COLUMN - 1;
		while(row >= 0) { 
			fullLine = true;
			for(int column = ROW - 1; column >= 0 && fullLine; column--) {
				fullLine =! matrix[row][column].isFree();
			}
			if(fullLine) {
				count++;
				clearRow(row);
			}
			else {
				row--;
			}
		}
		switch (count) {
			case 1: game.addPoints(100); break;
			case 2: game.addPoints(300); break;
			case 3: game.addPoints(600); break;
			case 4: game.addPoints(800); break;
		}
	}
	
	/**
	 * Delete the row corresponding to the position passed by parameter.
	 * @param row 
	 */
	private void clearRow(int theRow) {
		for(int row = theRow; row < COLUMN; row++) {
			for(int column = 0; column < ROW; column++){
				matrix[row][column].clear();
				if(row < COLUMN - 1) {
					if(!matrix[row + 1][column].isFree())
						matrix[row][column].put(matrix[row + 1][column].getGraphicCell());
					matrix[row + 1][column].clear();
				}
			}
		}
	}
	
}
