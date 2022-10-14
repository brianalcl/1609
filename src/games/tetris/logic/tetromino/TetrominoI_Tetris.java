package games.tetris.logic.tetromino;

import factory.Factory;
import games.tetris.logic.Map_Tetris;
import general.logic.Map;

public class TetrominoI_Tetris extends Tetromino_Tetris{
	
	/**
	* Create a new tetromino in the shape of an "I" with the TetrisMap and a factory.
	*/
	public TetrominoI_Tetris(Map_Tetris tetrisMap, Factory factory) {
		super(tetrisMap, factory);
		tetromino[0] = this.tetrisMap.getCell(Map.COLUMN - 1, 3);
		tetromino[1] = this.tetrisMap.getCell(Map.COLUMN - 1, 4);
		tetromino[2] = this.tetrisMap.getCell(Map.COLUMN - 1, 5);
		tetromino[3] = this.tetrisMap.getCell(Map.COLUMN - 1, 6);
	}
	
	@Override
	protected void moveA() {
		this.movements[0].setRyC(1, 2);
		this.movements[1].setRyC(0, 1);
		this.movements[2].setRyC(-1, 0);
		this.movements[3].setRyC(-2, -1);
	}
	
	@Override
	protected void moveB() {
		this.movements[0].setRyC(-2, 1);
		this.movements[1].setRyC(-1, 0);
		this.movements[2].setRyC(0, -1);
		this.movements[3].setRyC(1, -2);
	}
	
	@Override
	protected void moveC() {
		this.movements[0].setRyC(-1, -2);
		this.movements[1].setRyC(0, -1);
		this.movements[2].setRyC(1, 0);
		this.movements[3].setRyC(2, 1);
	}
	
	@Override
	protected void moveD() {
		this.movements[0].setRyC(2, -1);
		this.movements[1].setRyC(1, 0);
		this.movements[2].setRyC(0, 1);
		this.movements[3].setRyC(-1, 2);
	}
}