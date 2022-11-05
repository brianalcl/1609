package games.tetris.logic.tetromino;

import abstractFactory.AbstractFactory;
import games.tetris.logic.Map_Tetris;
import general.logic.Map;
import sound.Sound;

public class TetrominoO_Tetris extends Tetromino_Tetris{
	
	/**
	* Create a new tetromino in the shape of an "O" with the TetrisMap and a factory.
	*/
	public TetrominoO_Tetris(Map_Tetris tetrisMap, AbstractFactory factory, Sound sound) {
		super(tetrisMap, factory, sound);
		tetromino[0] = this.tetrisMap.getCell(Map.COLUMN -1, 4);
		tetromino[1] = this.tetrisMap.getCell(Map.COLUMN -1, 5);
		tetromino[2] = this.tetrisMap.getCell(Map.COLUMN -2, 4);
		tetromino[3] = this.tetrisMap.getCell(Map.COLUMN -2, 5);
	}
	
	@Override
	protected void moveA() {
		this.movements[0].setRyC(0, 1);
		this.movements[1].setRyC(-1, 0);
		this.movements[2].setRyC(1, 0);
		this.movements[3].setRyC(0, -1);
	}
	
	@Override
	protected void moveB() {
		this.movements[0].setRyC(-1, 0);
		this.movements[1].setRyC(0, -1);
		this.movements[2].setRyC(0, 1);
		this.movements[3].setRyC(1, 0);
	}
	
	@Override
	protected void moveC() {
		this.movements[0].setRyC(0, -1);
		this.movements[1].setRyC(1, 0);
		this.movements[2].setRyC(-1, 0);
		this.movements[3].setRyC(0, 1);
	}
	
	@Override
	protected void moveD() {
		this.movements[0].setRyC(1, 0);
		this.movements[1].setRyC(0, 1);
		this.movements[2].setRyC(0, -1);
		this.movements[3].setRyC(-1, 0);
	}
}