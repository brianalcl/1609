package games.tetris.logic.tetromino;

import factory.Factory;
import games.tetris.logic.TetrisMap;
import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import general.utilities.Pair;

public abstract class Tetromino {
	
	protected int rotation;
	protected Cell[] tetromino;
	protected TetrisMap tetrisMap;
	protected Pair<Integer, Integer>[] movements;
	protected GraphicCell representation;
	protected Factory factory;
	
	/**
	 * Create a new tetromino.
	 * @param tetrisMap The Tetris map.
	 * @param factory A Factory.
	 */
	@SuppressWarnings("unchecked")
	protected Tetromino(TetrisMap tetrisMap, Factory factory) {
		this.tetrisMap = tetrisMap;
		this.factory = factory;
		this.rotation = 0;
		this.tetromino = new Cell[4];
		this.movements = new Pair[4]; //A common warning in Java.
		this.representation = new GraphicCell(this.factory.getFood(), this.tetrisMap.getFreeCell().getBackground());
		for(int i = 0; i < movements.length; i++) {
			movements[i] = new Pair<Integer, Integer>();
		}
	}
	
	/**
	 * Allows the tetromino to be generated, if it has no space it will return false otherwise it will return true and it will be generated. 
	 * @return true if it can appear, false otherwise.
	 */
	public boolean show() {
		
		boolean possible = true;
		
		for(int i = 0; i<tetromino.length && possible; i++) {
			possible = tetromino[i].isFree();
		}
		
		if (possible) {
			for (int i = 0; i < tetromino.length; i++) 
				tetromino[i].put(representation);
		}
		
		return possible;
	}
	
	/**
	 * Move the tetromino to the left.
	 */
	public void moveLeft() {
		boolean possible = true;
		Pair<Integer, Integer> movement = new Pair<Integer, Integer>(0, -1);
		
		for(int i = 0; possible && i < tetromino.length; i++) {
			possible = checkMovement(tetromino[i], movement);
		}
		
		if(possible) {
			clearTetromino();
			for(int i = 0; i < tetromino.length; i++) {
				move(tetromino[i], movement, i);
			}
		}
	}

	/**
	 * Move the tetromino to the right.
	 */
	public void moveRight() {
		boolean possible = true;
		Pair<Integer, Integer> movement = new Pair<Integer, Integer>(0, 1);
		
		for(int i = 0; possible && i < tetromino.length; i++) {
			possible = checkMovement(tetromino[i], movement);
		}
		
		if(possible) {
			clearTetromino();
			for(int i = 0; i < tetromino.length; i++) {
				move(tetromino[i], movement, i);
			}
		}
	}
	
	/**
	 * Lower the tetromino by one position and return false on successful lowering,
	 * if it hit it returns true.
	 * @return false if not hit, true if hit.
	 */
	public boolean moveDown() {
		boolean crash = false;
		boolean possible = true;
		Pair<Integer, Integer> movement = new Pair<Integer, Integer>(-1, 0);
		
		for(int i = 0; possible && i < tetromino.length; i++) {
			possible = checkMovement(tetromino[i], movement);
		}
		
		if(possible) {
			clearTetromino();
			for(int i = 0; i < tetromino.length; i++) {
				move(tetromino[i], movement, i);
			}
		}
		else {
			crash = true;
		}
		return crash;
	}
	
	/**
	 * Rotate the tetromino to the right.
	 */
	public void rotateRight() {
		rotation = (rotation + 1) % 4;
		
		boolean rotated = moveAndRotate();
		
		rotation = (rotation + 2) % 4;
		
		if(!rotated)
			rotation = (rotation + 1) % 4;
	}
	
	/**
	 * Rotate the tetromino to the left.
	 */
	public void rotateLeft() {
		boolean rotated = moveAndRotate();
		
		rotation = (rotation + 1) % 4;
		
		if(!rotated) 
			rotation = (rotation + 3) % 4;
	}
	
	/**
	 * Move a tetromino block in one direction.
	 * @param cell the block to move.
	 * @param movement the offset that the block will have in rows and columns.
	 * @param pos position in the block array.
	 */
	private void move(Cell cell, Pair<Integer, Integer> movement, int pos) {
		int f = movement.getR();
		int c = movement.getC();
		cell = tetrisMap.getCell(cell.getRow() + f, cell.getColumn() + c);
		cell.put(representation);
		tetromino[pos] = cell;
	}
	
	/**
	 * Free all tetromino cells.
	 */
	private void clearTetromino() {
		for(int i = 0; i < tetromino.length; i++)
			tetromino[i].clear();
	}
	
	/**
	 * Allows you to rotate the tetromino.
	 * If it cannot be rotated it returns false, if it can be rotated it rotates and returns true.
	 * @return true if it could rotate, false if it couldn't.
	 */
	private boolean rotate() {
		boolean free = true;
		
		for(int i = 0; free && i < tetromino.length; i++) {
			free = checkMovement(tetromino[i], movements[i]);
		}
		
		if(free) {
			clearTetromino();
			for(int i = 0; i < tetromino.length; i++) {
				move(tetromino[i], movements[i], i);
			}
		}
		
		return free;
	}
	
	/**
	 * Check if it is possible to move a tetromino cell in one direction.
	 * @param cell the cell to move.
	 * @param movement the movement the cell will have in rows and columns.
	 * @return true if movable false if not movable.
	 */
	private boolean checkMovement(Cell cell, Pair<Integer, Integer> movement) {
		Cell adjacent = null;
		int column = 0;
		int row = 0;
		boolean possible = true;
			
		row = cell.getRow() + movement.getR();
		column = cell.getColumn() + movement.getC();
		if(column >= 0 && column < Map.ROW && row>=0 && row < Map.COLUMN) { 
			adjacent = tetrisMap.getCell(row, column);
			possible = (!adjacent.isFree() && inTetromino(adjacent)) || adjacent.isFree();
		}
		else
			possible = false;
		return possible;
	}
	

	/**
	* Returns true if the cell is inside the cell structure.
	* @param cell a cell.
	* @return true if the cell is inside the cell structure or false if it is not.
	*/
	private boolean inTetromino(Cell cell) {
		boolean is = false;
		for(int i = 0; i < tetromino.length && !is; i++) {
			is = cell.equals(tetromino[i]);
		}
		return is;
	}

	/**
	* Rotate the tetromino by turning it 90° depending on the level of rotation it currently has.
	* @return true if rotated, false if not rotated.
	*/
	private boolean moveAndRotate() {
		boolean rotated = false;
		switch(rotation) {
		case 0:
			moveA();
			break;
		case 1: 
			moveB();
			break;
		case 2: 
			moveC();
			break;
		case 3:
			moveD();
			break;
		}
		rotated = rotate();
		return rotated;
	}
	
	/**
	* Sets the shifts of the blocks in the first rotation phase turning right 90°.
	*/
	protected abstract void moveA();
	
	/**
	* Sets the shifts of the blocks in the second phase of rotation turning right 90°.
	*/
	protected abstract void moveB();
	
	/**
	* Sets the shifts of the blocks in the third phase of rotation turning right 90°.
	*/
	protected abstract void moveC();
	
	/**
	* Sets the shifts of the blocks in the fourth phase of rotation turning right 90°.
	*/
	protected abstract void moveD();
	
}
