package games.tetris.logic.tetromino;

import abstractFactory.AbstractFactory;
import games.tetris.logic.Map_Tetris;
import general.logic.Map;
import sound.Sound;

public class TetrominoZ_Tetris extends Tetromino_Tetris{
	
	/**
	* Create a new tetromino in the shape of an "Z" with the TetrisMap and a factory.
	*/
	public TetrominoZ_Tetris(Map_Tetris tetrisMap, AbstractFactory factory, Sound sound) {
		super(tetrisMap, factory,sound);
		tetromino[0] = tetrisMap.getCell(Map.COLUMN -2, 4);
		tetromino[1] = tetrisMap.getCell(Map.COLUMN -1, 3);
		tetromino[2] = tetrisMap.getCell(Map.COLUMN -1, 4);
		tetromino[3] = tetrisMap.getCell(Map.COLUMN -2, 5);
	}
	
	@Override
	protected void moveA() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(0, 2);
		this.movements[2].setRyC(-1, 1);
		this.movements[3].setRyC(-1, -1);
	}
	
	@Override
	protected void moveB() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(-2, 0);
		this.movements[2].setRyC(-1, -1);
		this.movements[3].setRyC(1, -1);
	}
	
	@Override
	protected void moveC() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(0, -2);
		this.movements[2].setRyC(1, -1);
		this.movements[3].setRyC(1, 1);
	}
	
	@Override
	protected void moveD() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(2, 0);
		this.movements[2].setRyC(1, 1);
		this.movements[3].setRyC(-1, 1);
	}
}
