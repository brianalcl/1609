package games.tetris.logic.tetromino;

import abstractFactory.AbstractFactory;
import games.tetris.logic.Map_Tetris;
import general.logic.Map;
import sound.Sound;

public class TetrominoL_Tetris extends Tetromino_Tetris{
	
	/**
	* Create a new tetromino in the shape of an "L" with the TetrisMap and a factory.
	*/
	public TetrominoL_Tetris(Map_Tetris tetrisMap, AbstractFactory factory, Sound sound) {
		super(tetrisMap, factory, sound);
		tetromino[0] = this.tetrisMap.getCell(Map.COLUMN -2, 4);
		tetromino[1] = this.tetrisMap.getCell(Map.COLUMN -2, 3);
		tetromino[2] = this.tetrisMap.getCell(Map.COLUMN -2, 5);
		tetromino[3] = this.tetrisMap.getCell(Map.COLUMN -1, 5);
	}
	
	@Override
	protected void moveA() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(1, 1);
		this.movements[2].setRyC(-1, -1);
		this.movements[3].setRyC(-2, 0);
	}
	
	@Override
	protected void moveB() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(-1, 1);
		this.movements[2].setRyC(1, -1);
		this.movements[3].setRyC(0, -2);
	}
	
	@Override
	protected void moveC() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(-1, -1);
		this.movements[2].setRyC(1, 1);
		this.movements[3].setRyC(2, 0);
	}
	
	@Override
	protected void moveD() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(1, -1);
		this.movements[2].setRyC(-1, 1);
		this.movements[3].setRyC(0, 2);
	}
	
}